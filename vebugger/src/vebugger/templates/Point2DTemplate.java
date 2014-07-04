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
        int hashCode = point2d.hashCode();

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

        sb.append("<style>");
        sb.append("table.java-awt-geom-Point2D {border-spacing: 0px; border-collapse: collapse; empty-cells: show; font-size: 12px; padding: 0;}");
        sb.append("table.java-awt-geom-Point2D > tbody > tr > td {text-align: center; vertical-align: center;}");
        sb.append("table.java-awt-geom-Point2D > tbody > tr > td.masterCell {text-align: left; vertical-align: top;}");
        sb.append("table.java-awt-geom-Point2D > tbody > tr > td.cell {border: 1px dotted silver; width: 100px; height: 100px;}");
        sb.append("table.java-awt-geom-Point2D > tbody > tr > td.up {border-bottom: 1px solid black;}");
        sb.append("table.java-awt-geom-Point2D > tbody > tr > td.left {border-right: 1px solid black;}");
        sb.append("table.java-awt-geom-Point2D > tbody > tr > td > p.rotate {transform: rotate(-90.0deg); -moz-transform: rotate(-90.0deg); -ms-transform: rotate(-90.0deg); -webkit-transform: rotate(-90.0deg);}");
        sb.append("table.java-awt-geom-Point2D-").append(hashCode)
                .append(" > tbody > tr > td > img {vertical-align: middle; position: relative; top: ").append(panY)
                .append("px; left: ").append(panX).append("px;}");
        sb.append("</style>");

        sb.append("<table class=\"java-awt-geom-Point2D java-awt-geom-Point2D-")
                .append(hashCode)
                .append("\"><tbody><tr><td></td><td colspan=\"2\">")
                .append(scale)
                .append("</td><td></td></tr><tr><td rowspan=\"2\"><p class=\"rotate\">")
                .append(-scale)
                .append("</p></td><td class=\"cell up left masterCell\"><img src=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAUAAAAFCAYAAACNbyblAAAAFklEQVQImWNggID/SBhDAC5BvCCGmQArdhTsYZweegAAAABJRU5ErkJggg==\" /></td><td class=\"cell up\"></td><td rowspan=\"2\"><p class=\"rotate\">")
                .append(scale)
                .append("</p></td></tr><tr><td class=\"cell left\"></td><td class=\"cell\"></td></tr><tr><td></td><td colspan=\"2\">")
                .append(-scale).append("</td><td></td></tr></tbody></table>");
    }
}
