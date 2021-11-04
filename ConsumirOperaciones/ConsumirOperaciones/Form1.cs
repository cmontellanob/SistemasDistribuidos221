using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ConsumirOperaciones
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            int a =int.Parse( txtA.Text);
            int b = int.Parse(txtB.Text);
            ServicioOperaciones.wsOperacionesSoapClient ws = new ServicioOperaciones.wsOperacionesSoapClient();
            int c = ws.Sumar(a,b);
            lblResultado.Text = c.ToString();

        }

        private void button3_Click(object sender, EventArgs e)
        {
            int a = int.Parse(txtA.Text);
            int b = int.Parse(txtB.Text);
            ServicioOperaciones.wsOperacionesSoapClient ws = new ServicioOperaciones.wsOperacionesSoapClient();
            int c = ws.Multiplicacion(a, b);
            lblResultado.Text = c.ToString();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            int a = int.Parse(txtA.Text);
            int b = int.Parse(txtB.Text);
            ServicioOperaciones.wsOperacionesSoapClient ws = new ServicioOperaciones.wsOperacionesSoapClient();
            int c = ws.Restar(a,b);
            lblResultado.Text = c.ToString();

        }

        private void button4_Click(object sender, EventArgs e)
        {
            int a = int.Parse(txtA.Text);
            int b = int.Parse(txtB.Text);
            ServicioOperaciones.wsOperacionesSoapClient ws = new ServicioOperaciones.wsOperacionesSoapClient();
            int c = ws.Division(a, b);
            lblResultado.Text = c.ToString();
        }
    }
}
