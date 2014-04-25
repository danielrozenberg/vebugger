package vebugger.templates;

import java.awt.Desktop.Action;
import java.util.EnumMap;

import vebugger.VebuggerTemplate;

public class DesktopActionTemplate extends VebuggerTemplate {

    private static final EnumMap<Action, String> ENABLED = new EnumMap<>(Action.class);
    private static final EnumMap<Action, String> DISABLED = new EnumMap<>(Action.class);
    static {
        ENABLED.put(
                Action.OPEN,
                "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAMAAAAoLQ9TAAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAAAgY0hSTQAAeiYAAICEAAD6AAAAgOgAAHUwAADqYAAAOpgAABdwnLpRPAAAAMZQTFRF////vre+jIKteGumpJ7Me3CwiX64tLTRT5xfLYdFrNK1wYUrz5k6VkiVd2qrqanIqciMq2cd////c2SkZVufnpbDQ5VVeqxweqxxeq1wwX8r+OiY8NiQfnasmZK+QYlNun8o+PDI+fLPaVyhZ1qglYq+HHdER5dRR5dQSJdRSJZRunko+Oiw+eu6+u3C++/J+/PWkMObT55VT59Vsnko+OCgq20lq20i+NiQ+OCY6NCIo2cd+NiInFsX+NB4+NCAjU8UnGEfeTCaTQAAAAF0Uk5TAEDm2GYAAAABYktHRAH/Ai3eAAAACXBIWXMAAABIAAAASABGyWs+AAAAnUlEQVQY023P3RaBQBiF4W+a0GBIUpGQn4RIYYSE+78pE7NaHfScvftsA1RCEpZQubEsy7i0SDWu3lCI0syz1caU0k6XqKpK+NLTtL6u6wPDtIaWacDItseIOs6ETHMEZq7rztFiufLW/sbferALgmB/CMNjROL4RCI4XzhWALgmScJuwp0PjzRlqZA3PDP2En4Nb5YJ/wb4FKqPfwE4Vhq3j4eKzwAAACV0RVh0ZGF0ZTpjcmVhdGUAMjAxNC0wNC0yNFQxMzowMTo1MS0wNzowMKWjJZ8AAAAldEVYdGRhdGU6bW9kaWZ5ADIwMTQtMDQtMjRUMTI6NTg6MDItMDc6MDD9ItfXAAAAAElFTkSuQmCC");
        ENABLED.put(
                Action.EDIT,
                "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAMAAAAoLQ9TAAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAAAgY0hSTQAAeiYAAICEAAD6AAAAgOgAAHUwAADqYAAAOpgAABdwnLpRPAAAAEhQTFRFwMDAAACAPz9fgICAf18/P1+fP1+///vwAICAP3+/P5+fv38//79/359fv7+/////X19fv7+fv59//9+foKCk37+fn5+fAAAAJZ56sgAAAAF0Uk5TAEDm2GYAAAABYktHRBcL1piPAAAACXBIWXMAAABIAAAASABGyWs+AAAAZ0lEQVQY01XKUQJAIBBF0WdKpFCR9r9TZZK8v3NnMHwjCAmMapqV0lovC5GxEv2HsauE2N4Vmxz2OrZogU14Q3MNnzl0fkK14+C9C4fJ9jW4Uxwx5LvjAFAsRtuVYqDOSJToQh/Sjzf2xQcpJWedRAAAACV0RVh0ZGF0ZTpjcmVhdGUAMjAxNC0wNC0yNFQxMzowMTozNS0wNzowMJeDCAsAAAAldEVYdGRhdGU6bW9kaWZ5ADIwMTQtMDQtMjRUMTI6NTc6NTktMDc6MDBGztbEAAAAAElFTkSuQmCC");
        ENABLED.put(
                Action.PRINT,
                "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAMAAAAoLQ9TAAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAAAgY0hSTQAAeiYAAICEAAD6AAAAgOgAAHUwAADqYAAAOpgAABdwnLpRPAAAAadQTFRF////zsWazMKWy8KUy8KVzMOYzsWcyMGa////zaBCx8Kgy8Ohwbuc+v7/+Pv/582T3L9t0aNDxL+jvLmg+Pz/9/v/+v3/+///+v///P//vrymt7Wn9vz/f5a+do23Zn+tVG+fQF2U+f7/uLipq7nYa42/FjqDq7Ct8ff/8Pf/8vr/9fv/9/z/9fz/8vn/rbCuFzqDaou9naav6vT/g5m/epC4aYKuWHGfQ16S7fb/nqavaIi6+/369/n6kZ205vH/5fH/6PH/6fL/6fP/5/L/5/D/kZ+09/n7/P36aIi7ZYS37fL26O/0ipm4ipq6jJm4jJu5jZq5jJq5i5u5iZi47fP2ZYW4YoK13uby2eLv2ePv2ePw2eTw2uPw2OPv2OLv3ufyX4Cz0N3uydjqyNbqydfpydfqydbqyNbp0NztYH+xXXyvwtTqv9DovM/nvM7nvc7nvc/ovc/nvtDnXH2wV3irVneqVHaqVXWpVXSpVXWqU3WpVXaqr7zaUXKngZ7OgqDOgqHOgp/Ogp/QgaDOsL3aUXGmVnSoVXWoVnWoVnWnVXWnVXSotpk8cgAAAAF0Uk5TAEDm2GYAAAABYktHRE9uZkFJAAAACXBIWXMAAABIAAAASABGyWs+AAAA4UlEQVQY02NgwAYYmZhZWNmQBNg5gICTixsuwMPLx8fLLyAoBBMQFhHlExOXkJSCCUjLyMrJKygqKYN5Kqpq6hqaWto6unr6BqoqDAyGHBxGxiamZuYWllYcHIYMDNY2tnb2Do5Ozi6ubu4engwMXt4+vn7+AYFBwcEhPqFhDAzhEZFR0TExMbGxMXHxCeEMDIlJySmpaWlp6ekZKcmZWQwM2Tm5eXl5+QWFeUXFuTklDAylZeUVlZUVFVXVlZU1ZaUMDLV19Q2NTY3NINRSVwt0WWtbe0dnZ2dXZ3dPWysDADBQN16HO19ZAAAAJXRFWHRkYXRlOmNyZWF0ZQAyMDE0LTA0LTI0VDEzOjAxOjQ2LTA3OjAwrK4bjwAAACV0RVh0ZGF0ZTptb2RpZnkAMjAxNC0wNC0yNFQxMjo1ODowNC0wNzowMJ7y4u0AAAAASUVORK5CYII=");
        ENABLED.put(
                Action.MAIL,
                "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAMAAAAoLQ9TAAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAAAgY0hSTQAAeiYAAICEAAD6AAAAgOgAAHUwAADqYAAAOpgAABdwnLpRPAAAAKtQTFRF////v7aI+fr81LJpu7SK2r181bJpvLSKuLGN9/j8cIWv9/n7kaXH9/j74MiP1LJouLKNsq+Q9Pf79ff89Pf8rqyU8fX7iJ3AfJG48PT7p6iY7fL77fP67fL67fP77PP6oaSd6fD66fD5iJ3Bm6Cg5e355e365e755u36lZ2l4ev54uv5b4Wv4uv4j5mo3+n43+r43+n54On54On4i5as3ej4iZ3BhpSug5KxM/8gRwAAAAF0Uk5TAEDm2GYAAAABYktHRAnx2aXsAAAACXBIWXMAAABIAAAASABGyWs+AAAAkklEQVQY023PxxaCQAyFYSxYYiyMgCNNUAZEkUFlxPd/MktQNvzZfYt7TjSto15TC/1vg78MCfTRuIHJFGaI84W+XBEYbM1Mk73PILBssBE3HLYWgeN6vh94u8B1CMII9ogHDlFIEIskTYQQxzQmyE5w/mzkl4ygkFKW19u9LAuCSoFCfPBcVQS1+lUTPNs6Xn8BmT8P5k9G0L8AAAAldEVYdGRhdGU6Y3JlYXRlADIwMTQtMDQtMjRUMTM6MDE6NTktMDc6MDCWTGv4AAAAJXRFWHRkYXRlOm1vZGlmeQAyMDE0LTA0LTI0VDEyOjU3OjU2LTA3OjAwsIamLQAAAABJRU5ErkJggg==");
        ENABLED.put(
                Action.BROWSE,
                "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAMAAAAoLQ9TAAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAAAgY0hSTQAAeiYAAICEAAD6AAAAgOgAAHUwAADqYAAAOpgAABdwnLpRPAAAAXpQTFRF////TafLTqbJUKfIUqjJUKnMT6jKSabMx7qT///+0urGssnIlMzLT4WofpipS6bIscvK0Mqo7uvN///////9hsXH2ezJU87MQomwcZu1RqLH7ceogH9l6unP6sSns+zLVM/MSqffJIO3paSCTqbI0+rH6ejMtKtjpsiOysaM8uvRSqesVa3QWpDQWHCvmJRvUafJ1evHy+fH78iwhspvqspw9vDamqt0VWxHWpTUWXSxeXVxVKjJk8rJ0+rJ0erNrqZrsM5zsM93jq1SuLJzeJNuWZbVWXayV1RyU6jKUabJlcrKlMzNTqyxlIxRtrJXlJJWdXFRV3O2WXWyV3a0eHVyUqjLVc7KVtDMVo3Td29OdXNVdnVUeXVyWHa1WHa0d3RvlZNxT6jNVqvMWa7MWrLQUZGynw0HV3i4WHe2WHe1eHVvTkxwUa3PV47NWZPPWpfUWXizWXi0eHVwUE5wUGzSVXCuWHWxWXezV3e1T01wlpNteHZylZRxdcjWUgAAAAF0Uk5TAEDm2GYAAAABYktHREjwAtTqAAAACXBIWXMAAABIAAAASABGyWs+AAAAr0lEQVQY02NgIBIwMjGzsCK4bOwcnFzcPLx8UD6/gKCQsIiomLiEJERAilNaRlZOWF5BUUkZxFdRFVZT19DU0tbR1dMHCRgYGgkbm5iamVtYWlmDBGxs7ewdHJ2cXVzd3D1AAp5e3j6+fv4BgUHBIaEgAcmw8IjIqOiY2Lj4hESwLUnJKalp6RmZWdk5EGuVc/PyCwqLsopLlKEuUy4tK6+oTKhSRji+utijpha7NwGkYSEw9sEi4wAAACV0RVh0ZGF0ZTpjcmVhdGUAMjAxNC0wNC0yNFQxMzowMTo0MS0wNzowMGkJJQEAAAAldEVYdGRhdGU6bW9kaWZ5ADIwMTQtMDQtMjRUMTI6NTg6MDYtMDc6MDAJbfPEAAAAAElFTkSuQmCC");
        DISABLED.put(
                Action.OPEN,
                "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAABHNCSVQICAgIfAhkiAAAAbVJREFUOI2lkyGrKlEUhb/hjiBGR4taDBaTCILFppjFNiaTwSL+APuARkEQFMvABG0GwWa0TBFtBkEQDIoy6KBzXvAxXO/4XrkrrrPWx94HNvxS0idzNpsJ0zQ5Ho+EQiFSqRTFYvFj1mPOZjMxn89JpVKuZ5om+Xz+I0T+aZimic/nY7VauV4wGMRxHFqtltjv90QiEQqFArlcTnIB7XZbBINB1us12+3WLcfjcRKJBOPxmHK57Pqj0YjFYiEkgGazKTqdDgCNRgPLstxgNptls9kQj8c9+2+3WyRN04SqqgBcLhd2ux39fp9kMglANBpluVzi9/s9gNvthvx8PgkEAgAEAgEikQgAk8kEx3EIh8Ocz2cURUEIgSRJCCEAOBwOL8D9fnepX19fpNNpMpnM65dlmVgsxnQ6deEA+/0eVVW9AIBer+cZV1GUt5yiKJRKJUm2LAvbtt2HwWBArVbzAL7rdDphGMZrQtu23Z2GwyHVavUN+FOWZWEYBpqmSQCyZVnc73d0XadSqfy3/Hg83soA8vV6Rdd1VFV1J/mk5/PpKcPfW6jX6/9uflO32/14UL/SH2l/x7V3Eg/fAAAAAElFTkSuQmCC");
        DISABLED.put(
                Action.EDIT,
                "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAABHNCSVQICAgIfAhkiAAAAR9JREFUOI2d0jGqwkAQgOE/shCw0MJOYuEdbINhbKy8QiCFB7BLJ+YWErDZxiuIhBSewkIWNOeYV7xnQIy+6PTfPzuwXq/XU1rOZDKhKApvvV7r7XYjz3PPLBYLjDFst1viOMb3fQAGg0EN+/0+AGVZIiLa7XZZLpcA6n36gvl8ThRFOOc4HA6Y1WrFdDr9F2dZ9oCdcwAYgCiK3uLZbPaEz+czQRD8Br7Bl8uFPM+9zre4KAoP4GWgDX4ZaIsbA+/waDR6WmYAjscjANZakiQhDEP2+z1AjdM0xVr7FOjcYVVVjMdjwjDker0yHA4fNjdhgPoeEdHNZgOAc46yLBtvbpzdbqeAnk4ntdaqiKiItP7iAHegIqJ/wY9Gga/gD9p3xOVM9ZIjAAAAAElFTkSuQmCC");
        DISABLED.put(
                Action.PRINT,
                "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAABHNCSVQICAgIfAhkiAAAAaVJREFUOI2lk7vq8kAQxc8m8W0C2lmJCDYWIpa2voT4BD5DSm+FlYiNYESwshLBV7D1gsbcdib7FZKNlz8231TL7Mxvz5ndBf4zxGdis9koZs4KhIBpmiiVSl+1AGB9JogIlUrlLTccDrFer5VhGCiXy28g4xMgpQQzQ0qp17ZtQymF4/GI1WqlfipIkgRKvdUgn89rO67r/rbAzFBKwXEcBEGA2+2G6/WK8/mMwWAAIvoGLBYLtd/vMZ1OEccxiAjtdhumaUIIASGEtheGIYrFomo2mygUCk/AbrdDt9tFp9PBeDwGEWE0GmkFl8sFp9MJjuPA931st1sAQK/XewKSJAEzg4gQhiGYGa1WS/sWQkApBSkloihCFEWwLAtJkjwBRATP8zRkMpno5r+G/Hg8YFkWmDlT4HkeiAi1Wu2rOb2VVMn9fkcul8sAzIwgCBDH8dcVvoZSSlv6Avi+DyJ6A7yenEa6JqIMIKVEv9/XDX81voINw8gGDADL5VLN53PYtq03U7mf/tM4HA6o1+vZb3RdV81mM/14fs2BmdFoNFCtVsU/I2kfopYgpdwAAAAASUVORK5CYII=");
        DISABLED.put(
                Action.MAIL,
                "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAABHNCSVQICAgIfAhkiAAAATZJREFUOI21kkGKAjEQRV+aWbXXEheCeIhIgyio13DjxpXgARobReJGvFYUG5KqWQw6OsaexTAfalEk+fV+EfijzGPjnNOmy71ezzSd45zTuq6T5ZzT1IDssRGRt+atVgtjDPv9/snkySDGiKoyn89RVcqypCxLVJU8z8nznCzL2O126ahVVenlcvm1qqq6G3z8JBARFosFs9mM7XYLwPV65Xw+471nOp0SYyRpEEIgxshkMiHGSL/fx5ivxasqxhhEhBBC2uBGsFwuGY1GHA6HF4LxeNxMEEJgOBwiInS7XVS/92WMIcb4O8FqtaIoCo7H4wtBURTNBCLCYDBAROh0OvfsN6nqewIRQVVZr9dYazmdTgDUdY33Hu891tqnD/cSAcBaC0C73SaltxFUlc1mk3z0b/oEoqEROvuT31EAAAAASUVORK5CYII=");
        DISABLED.put(
                Action.BROWSE,
                "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAABHNCSVQICAgIfAhkiAAAAeRJREFUOI3FkrFqIlEUhr9zZ4ZBg9gExAHFNEqYIpIuBKazDJlHyBOIT6IZyANYp7KQdHmBFBGLIEGEgTE3iAmKGCEQuVsscdd1bbbZvzzn/B/3nP/C/5bsa1xfXxtjDCKCUgqAer2+M79TiKLIrNdrfN+nVqsRxzHj8ZjPz0/u7+/xPG8LpH43N5tNc3p6ytnZGScnJ4gIpVKJ+XxOpVKhWq2itSaKIvNXwNfXF+fn57iuy83NDa+vrzw+PnJxccHHxwciQj6fZzgc0m63DYD9bW61WiYMQ0SEXC7H8fEx/X6fVCrFdDql2+1ycHDAarXCtm3m8/n2C5RSiAjD4RDP8/B9n+VyyWq1wnEcDg8PeXh4QCmFUoqXl5dtgIjw/PyM4zjEcUy/3yebzeI4Dre3t2QyGcrl8iaVJEnYWgFgMBggIogIs9kMrTVHR0csFguenp6wbRuRnwEUCoVtgDEGpRSz2QylFMvlkslkwmQyQURwXRdjNsfH87zdfxBFkbFtG8uysCwLrTV3d3cEQbAxf9+p0+nITozZbBaAt7c33t/fSafTBEGw6YsIo9GIMAx/1fhD7Xbb9Ho9jDE4jrPZGWA0GnF5ecnV1ZXsBXyr1WoZrTVJklAsFvE8j0ajsXf+n/UDZz+6fjk0cv8AAAAASUVORK5CYII=");
    }

    @Override
    public Class<?> getType() {
        return Action.class;
    }

    @Override
    public void render(StringBuilder sb, Object obj) {
        Action currentAction = (Action) obj;

        sb.append("<style>.java-awt-Desktop-Action td {font-family: monospace; font-size: 0.7em; text-align: center;}")
                .append(".java-awt-Desktop-Action td.active {color: black;}")
                .append(".java-awt-Desktop-Action td.inactive {color: silver;}</style>")
                .append("<table class=\"java-awt-Desktop-Action\"><tbody><tr>");
        for (Action someAction : Action.values()) {
            sb.append("<td><img src=\"");
            if (someAction == currentAction) {
                sb.append(ENABLED.get(someAction));
            } else {
                sb.append(DISABLED.get(someAction));
            }
            sb.append("\" /></td>");
        }
        sb.append("</tr><tr>");
        for (Action someAction : Action.values()) {
            sb.append("<td class=\"");
            if (someAction == currentAction) {
                sb.append("active");
            } else {
                sb.append("inactive");
            }
            sb.append("\">").append(someAction.toString()).append("</td>");
        }
        sb.append("</tr></tbody></table>");
    }
}
