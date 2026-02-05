package Main;
import Vista.*;
import Controlador.*;

public class AnalisisComplejidad
{
    public static void main(String[] args)
    {
        Vista vista = new Vista();
        Controlador controlador = new Controlador(vista);
        controlador.iniciarPrograma();
    }
}
