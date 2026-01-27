/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uno;

/**
 *
 * @author artyom
 */
public class MenuItem {
    private String label;
    private Action action;
    
    public MenuItem(String label, Action action) {
        setLabel(label);
        setAction(action);
    }

    public String getLabel() {
        return label;
    }

    public Action getAction() {
        return action;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setAction(Action action) {
        this.action = action;
    }
    
    public String toString() {
        return label;
    }
}