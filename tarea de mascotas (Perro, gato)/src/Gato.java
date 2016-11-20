/*Tarea3.
Hacer un programa que maneje mascotas. Usted puede elegir si tiene un perro o un gato.
Todas las mascotas tienen nombre, puntos de vida y ejecutan acciones, especificamente
de esta manera:
- El perro tiene 50 puntos de vida y puede ladrar (-2), comer(+10) y correr (-15).
- El gato tiene 30 puntos de vida y puede dormir(+2), comer(+5) y caminar.
Cuando elija su mascota ud elije las acciones que realizar. Puede salir del programa
cuando muera la mascota o cuando lo desee el usario. Independiente mente del caso se
deben guardar el nombre de la mascota y los pts de vida en un archivo.
 */
public class Gato {
    private String nombre;
    private int pvida, action;

    public Gato(String nombre, int pvida, int action){
        this.nombre=nombre;
        this.pvida=pvida;
        this.action=action;
    }
    //hacer constructor
/*    public Gato(){
        this.pvida=30;
   }
*/
    public int Dormir () {
        this.setPvida(this.getPvida() + 2);
        return pvida;
    }

    public int Comer(){
        this.setPvida(this.getPvida()+5);
        return pvida;
    }

    public int Caminar() {
        this.setPvida(this.getPvida()+0);
        return pvida;
    }

    public int getPvida(){
        return pvida;
    }

    public String getNombre(){
        return nombre;
    }

    public int getAction(){
        return action;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public void setPvida(int pvida){
        this.pvida=pvida;
    }

    public void setAction(int action){
        this.action=action;
    }

}


