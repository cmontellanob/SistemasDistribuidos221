/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import java.io.Serializable;

/**
 *
 * @author Carlos
 */
public class Factura implements Serializable {
    Empresa empresa;
    int idfactura;
    double monto;

    public Factura(Empresa empresa, int idfactura, double monto) {
        this.empresa = empresa;
        this.idfactura = idfactura;
        this.monto = monto;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public int getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(int idfactura) {
        this.idfactura = idfactura;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
            
    
}
