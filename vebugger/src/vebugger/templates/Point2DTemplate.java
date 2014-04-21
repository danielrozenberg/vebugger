package vebugger.templates;

import java.awt.geom.Point2D;

import vebugger.VebuggerTemplate;

public class Point2DTemplate extends VebuggerTemplate {

    @Override
    public Class<?> getType() {
        return Point2D.class;
    }

    @Override
    public void render(StringBuilder sb, Object obj) {
        Point2D point2d = (Point2D) obj;
        double x = point2d.getX();
        double y = point2d.getY();
        double maxAbs = Math.max(Math.abs(x), Math.abs(y));

        long a = 1;
        long b = 1;
        long scale = 0;
        do {
            scale = a * b;
            if (a < 10) {
                a++;
            } else {
                a = 2;
                b *= 10;
            }
        } while (scale < maxAbs);

        double panX = (x / scale) * 100 + 98;
        double panY = (-y / scale) * 100 + 97;

        sb.append("<style>table {border-spacing: 0px; border-collapse: collapse; empty-cells: show;}\n")
                .append("td {text-align: center; vertical-align: center;}\n")
                .append("td.masterCell {text-align: left; vertical-align: top;}\n")
                .append("td.cell {border: 1px dotted silver; width: 100px; height: 100px;}\n")
                .append("td.up {border-bottom: 1px solid black;}\n")
                .append("td.left {border-right: 1px solid black;}\n")
                .append(".rotate {-moz-transform: rotate(-90.0deg);}\n")
                .append("img {vertical-align: middle; position: relative; top: ")
                .append(panY)
                .append("px; left: ")
                .append(panX)
                .append("px;}</style>\n")
                .append("<table border=\"0\" cellpadding=\"0\"><tbody><tr><td></td><td colspan=\"2\">")
                .append(scale)
                .append("</td><td></td></tr><tr><td rowspan=\"2\"><p class=\"rotate\">")
                .append(-scale)
                .append("</p></td><td class=\"cell up left masterCell\"><img src=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAUAAAAFCAYAAACNbyblAAAAFklEQVQImWNggID/SBhDAC5BvCCGmQArdhTsYZweegAAAABJRU5ErkJggg==\" /></td><td class=\"cell up\"></td><td rowspan=\"2\" class=\"rotate\">")
                .append(scale)
                .append("</td></tr><tr><td class=\"cell left\"></td><td class=\"cell\"></td></tr><tr><td></td><td colspan=\"2\">")
                .append(-scale).append("</td><td></td></tr></tbody></table>");
    }
}
