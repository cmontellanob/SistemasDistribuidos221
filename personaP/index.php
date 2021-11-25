<?php
require_once 'vendor/autoload.php';

use Firebase\JWT\JWT;

$key = 'Laversecreta';


include('conexion.php');

if (!isset($_SERVER['PATH_INFO'])) {
    $ruta = "/";
} else {
    $ruta = $_SERVER['PATH_INFO'];
}


$arregloRuta = explode('/', $ruta);

$recurso = $arregloRuta[1];

if (isset($arregloRuta[2])) {
    $id = $arregloRuta[2];
    // echo ' recurso= ' . $recurso . ' id=' . $id;
}
// var_dump($_SERVER['argv']);
// var_dump($_POST);
// var_dump($_REQUEST);

// parse_str(file_get_contents("php://input"),$put_vars);
// var_dump($put_vars);

// $authHeader = $_SERVER['HTTP_AUTHORIZATION'];
// echo $authHeader;

//foreach ($_SERVER as $s => $valor) {
//   echo $s.'=>'.$valor,"\n";
//}
$cabeceras = getallheaders();
if (isset($cabeceras['Authorization'])) {
    $autorizacion = $cabeceras['Authorization'];
    
    $jwt = substr($autorizacion, 7);
    try {
        
        $data = JWT::decode($jwt, $key, array('HS256'));
        echo "autorizado";
        if ($recurso == 'persona') {
            switch ($_SERVER['REQUEST_METHOD']) {
                case 'GET': //Recuperar
                    if (isset($id)) {
                        $sql = "SELECT id, carnet, nombre from persona WHERE id=$id";
                        $resultado = $con->query($sql);

                        $r = mysqli_fetch_assoc($resultado);
                        print json_encode($r);
                    } else {
                        $sql = "SELECT id, carnet, nombre from persona";
                        $resultado = $con->query($sql);

                        $filas = array();
                        while ($r = mysqli_fetch_assoc($resultado)) {
                            $filas[] = $r;
                        }
                        print json_encode($filas);
                    }

                    break;
                case 'POST': //Grabar
                    $carnet = $_POST['carnet'];
                    $nombre = $_POST['nombre'];
                    $sql = "insert into persona( carnet, nombre) values( '$carnet', '$nombre')";
                    $resultado = $con->query($sql);
                    if ($resultado)
                        echo 'se inserto con exito';
                    else
                        echo "hubo un error";
                    break;
                case 'PUT': //actualizar
                    // print $_SERVER['PATH'];
                    parse_str(file_get_contents("php://input"), $put_vars);
                    $nombre = $put_vars['nombre'];
                    $carnet = $put_vars['carnet'];


                    if (isset($id)) {
                        $sql = "UPDATE persona set nombre = '$nombre', carnet = '$carnet' WHERE id=$id";
                        $resultado = $con->query($sql);
                        $sql2 = "SELECT id, carnet, nombre from persona WHERE id=$id";
                        $resultado2 = $con->query($sql2);

                        print json_encode(mysqli_fetch_assoc($resultado2));
                    } else {
                        http_response_code(404);;
                    }
                    break;
                case 'PATCH': //actualizacion parcial
                    parse_str(file_get_contents("php://input"), $put_vars);
                    if (isset($id)) {
                        if (isset($put_vars['nombre'])) {
                            $nombre = $put_vars['nombre'];
                            $sql = "UPDATE persona set nombre ='$nombre' WHERE id=$id";
                        }
                        if (isset($put_vars['carnet'])) {
                            $carnet = $put_vars['carnet'];
                            $sql = "UPDATE persona set carnet ='$carnet' WHERE id=$id";
                        }
                        $resultado = $con->query($sql);
                        $sql2 = "SELECT id, carnet, nombre from persona WHERE id=$id";
                        $resultado2 = $con->query($sql2);
                        print json_encode(mysqli_fetch_assoc($resultado2));
                    } else {
                        http_response_code(404);
                    }
                    break;
                case 'DELETE': //Borrar

                    if (isset($id)) {
                        $sql2 = "SELECT id, carnet, nombre from persona WHERE id=$id";
                        $resultado2 = $con->query($sql2);
                        // var_dump($resultado2);
                        if ($resultado2) {
                            print json_encode(mysqli_fetch_assoc($resultado2));
                            $sql = "DELETE from persona WHERE id=$id";
                            $resultado = $con->query($sql);
                        } else {
                            http_response_code(404);
                        }
                    } else {
                        http_response_code(404);
                    }
                    break;
            }
        }
    } catch (Exception $e) {
        var_dump($e);
    }
} else
    echo "no se pro´porciono el token";
