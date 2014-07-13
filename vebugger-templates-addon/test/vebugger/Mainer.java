package vebugger;

import java.awt.Point;

public class Mainer {

    public static void main(String[] args) {
        printObjectWithAndWithoutVebugger(new Point(0, 0));
        printObjectWithAndWithoutVebugger(new Point(1, 0));
        printObjectWithAndWithoutVebugger(new Point(-1, 0));
        printObjectWithAndWithoutVebugger(new Point(0, 1));
        printObjectWithAndWithoutVebugger(new Point(0, -1));
    }

    private static void printObjectWithAndWithoutVebugger(Object object) {
        System.out.println(object);
        System.out.println(vebugger.VisualDebuggerAid.toString(object));
    }

}
