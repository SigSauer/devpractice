//package com.sigsauer.devpractice.learning.instances;
//
//public class Instances {
//
//
//
//    public static void main(String[] args) {
//        Object o1 = 78;
//        Object o2 = 12.7;
//        Object o3 = "";
//        Object o4 = Varior.VAR_B;
//
//        Double d1 = value(o1, Double.class);
//        Double d2 = value(o2, Double.class);
//        Double d3 = value(o3, Double.class);
//        Double d4 = value(o4, Double.class);
//
//        Varior v1 = value(o1, Varior.class);
//        Varior v2 = value(o2, Varior.class);
//        Varior v3 = value(o3, Varior.class);
//        Varior v4 = value(o4, Varior.class);
//
//        Integer i1 = value(o1, Integer.class);
//        Integer i2 = value(o2, Integer.class);
//        Integer i3 = value(o3, Integer.class);
//        Integer i4 = value(o4, Integer.class);
//    }
//
//    public static <T> T value(Object o, Class<T> cls) {
//            if(cls.isInstance(o)) {
//                return (T) o;
//            }else {
//                if(cls == Double.class)
//                    return (T) Double.valueOf(0.);
//                else if(cls == Integer.class)
//                    return (T) Integer.valueOf(0);
//                else return (T) Varior.VAR_A;
//            }
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
////    public static void m1()
////    {
////        Double d = 0.57;
////        Double dd = -0.12;
////        Integer i = 12;
////        Integer ii = -3;
////        Character c = 'c';
////
////        Double dddd;
////        Double l = null;
////        System.out.println(bab(l));
////
////        System.out.println(0L == 0.d);
////
////        System.out.println("integers:"+"\nd = 0.57: "+lal(d)+"\ndd = -0.12: "+lal(dd)+"\ni = 12: "+lal(i)+"\nii = -3: "+lal(ii)+"\n c = 'c': "+lal(c)+"\n");
////        System.out.println("doubles: "+"\nd = 0.57: "+vav(d)+"\ndd = -0.12: "+vav(dd)+"\ni = 12: "+vav(i)+"\nii = -3: "+vav(ii)+"\n c = 'c': "+vav(c));
////    }
////    public static boolean lal(Object o) {
////        if(o instanceof Number) return 0 < ((Number) o).intValue();
////        return false;
////    }
////
////    public static boolean vav(Object o) {
////        if(o instanceof Number) return 0 < ((Number) o).doubleValue();
////        return false;
////    }
////
////    public static String bab(Object o) {
////        if(o == null) o = new Object();
////        if(o instanceof Number) return "number";
////        return "nullamba, bro";
////    }
//}
