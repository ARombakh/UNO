/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uno;

/**
 *
 * @author artyom
 */
public class SayUno extends Action {
    private boolean sayUno;

    public SayUno(boolean sayUno) {
        this.sayUno = sayUno;
    }

    public boolean isSayUno() {
        return sayUno;
    }
}
