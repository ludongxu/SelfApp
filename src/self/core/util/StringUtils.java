package self.core.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Random;

public class StringUtils {
	private static final StringBuffer ALL_BUFFER = new StringBuffer("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
            );
    private static final StringBuffer C_BUFFER = new StringBuffer("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
            );
    private static final StringBuffer D_BUFFER = new StringBuffer("0123456789");
    public static final int RANDOM_ALL = 1;
    public static final int RANDOM_CHARACTER = 2;
    public static final int RANDOM_DIGIT = 3;
    private static Random random = new Random();

 

    public StringUtils() {
        super();
    }

    public static final String byteArrayToHexString(byte[] arg5) {
        if(arg5 != null && arg5.length != 0) {
            StringBuilder v1 = new StringBuilder(arg5.length * 2);
            int v2 = arg5.length;
            int v0;
            for(v0 = 0; v0 < v2; ++v0) {
                int v3 = arg5[v0] & 255;
                if(v3 < 16) {
                    v1.append('0');
                }

                v1.append(Integer.toHexString(v3));
            }

            return v1.toString().toUpperCase();
        }

        throw new IllegalArgumentException();
    }

    public static String encodeUTF8(String arg2) {
       String v0;
    	
    	if (arg2 == null) {
    		return "";
    	}
    	
        if(!"".equals(arg2)) {
        	try {
				v0 = URLEncoder.encode(arg2, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				LogUtils.e("BaseLib", ((Throwable)e));
				v0 = "";
			}
        } else {
        	v0 = "";
        }
   
        return v0;
    }

    public static String formatFileSize(long arg10) {
        double v0_1;
        String v0;
        long v2 = 1024;
        int v9 = 3;
        double v4 = 100;
        double v6 = 0.01;
        if(arg10 < v2) {
            v0 = String.valueOf(arg10);
        }
        else {
            if(arg10 >= v2 && arg10 < 1048576) {
                v0 = String.valueOf(((long)((((double)arg10)) / 1024))) + "K";
                return v0;
            }

            if(arg10 >= 1048576 && arg10 < 1073741824) {
                v0_1 = (((double)arg10)) / 1048576;
                v0 = new StringBuilder(String.valueOf((((double)(((long)v0_1)))) + (((double)(((long
                        )((v0_1 - (((double)(((long)v0_1))))) * v4))))) * v6)).toString();
                if(v0.length() - v0.lastIndexOf(".") > v9) {
                    v0 = v0.substring(0, v0.lastIndexOf(".") + 3);
                }

                v0 = String.valueOf(v0) + "M";
                return v0;
            }

            if(arg10 >= 1073741824 && arg10 < 1099511627776L) {
                v0_1 = (((double)arg10)) / 1073741824;
                v0 = new StringBuilder(String.valueOf((((double)(((long)v0_1)))) + (((double)(((long
                        )((v0_1 - (((double)(((long)v0_1))))) * v4))))) * v6)).toString();
                if(v0.length() - v0.lastIndexOf(".") > v9) {
                    v0 = v0.substring(0, v0.lastIndexOf(".") + 3);
                }

                v0 = String.valueOf(v0) + "G";
                return v0;
            }

            v0 = String.valueOf(((long)((((double)arg10)) / 0))) + "T";
        }

   // label_7:
        return v0;
    }

    public static String getFileNameFromUrl(String arg3) {
        if(StringUtils.isBlank(arg3)) {
            throw new IllegalArgumentException();
        }

        String v0 = arg3.trim();
        int v1 = v0.lastIndexOf(63);
        if(v1 > 1) {
            v0 = v0.substring(0, v1);
        }

        v1 = v0.lastIndexOf("/");
        if(v1 >= 0) {
            v0 = v0.substring(v1 + 1);
        }

        return v0;
    }

    public static String getFileSuffix(String arg1) {
        String v0;
        if(StringUtils.isBlank(arg1)) {
            v0 = "";
        }
        else {
            int v0_1 = arg1.lastIndexOf(".");
            if(v0_1 >= 0) {
                v0 = arg1.substring(v0_1 + 1);
            }
            else {
                v0 = "";
            }
        }

        return v0;
    }

    public static String getRandomString(int arg8, int arg9) {
        int v0;
        int v7 = 3;
        int v6 = 2;
        int v1 = 0;
        StringBuffer v2 = new StringBuffer();
        if(arg9 == 1) {
            v0 = StringUtils.ALL_BUFFER.length();
        }
        else if(arg9 == v6) {
            v0 = StringUtils.C_BUFFER.length();
        }
        else if(arg9 == v7) {
            v0 = StringUtils.D_BUFFER.length();
        }
        else {
            v0 = 0;
        }

        while(v1 < arg8) {
            if(arg9 == 1) {
                v2.append(StringUtils.ALL_BUFFER.charAt(StringUtils.random.nextInt(v0)));
            }
            else if(arg9 == v6) {
                v2.append(StringUtils.C_BUFFER.charAt(StringUtils.random.nextInt(v0)));
            }
            else if(arg9 == v7) {
                v2.append(StringUtils.D_BUFFER.charAt(StringUtils.random.nextInt(v0)));
            }

            ++v1;
        }

        return v2.toString();
    }

    public static byte[] hexStringToByteArray(String arg8) {
        int v7 = 16;
        if(StringUtils.isBlank(arg8)) {
            throw new IllegalArgumentException();
        }

        String v1 = arg8.trim();
        int v2 = v1.length();
        byte[] v3 = new byte[v2 / 2];
        int v0;
        for(v0 = 0; v0 < v2; v0 += 2) {
            v3[v0 / 2] = ((byte)((Character.digit(v1.charAt(v0), v7) << 4) + Character.digit(v1.charAt
                    (v0 + 1), v7)));
        }

        return v3;
    }

    public static boolean isBlank(String arg5) {
        boolean v0 = false;
        if(arg5 != null) {
            int v3 = arg5.length();
            if(v3 != 0) {
                int v2 = 0;
                while(true) {
                    if(v2 >= v3) {
                        break;
                    }
                    else if(Character.isWhitespace(arg5.charAt(v2))) {
                        ++v2;
                        continue;
                    }

                    return v0;
                }

                v0 = true;
            }
            else {
           //     goto label_5;
                v0 = true;
            }
        }
        else {
      //  label_5:
            v0 = true;
        }

  //  label_6:
        return v0;
    }

    public static boolean isEmpty(String arg1) {
        boolean v0;
        if(arg1 == null || arg1.length() == 0) {
            v0 = true;
        }
        else {
            v0 = false;
        }

        return v0;
    }

    public static boolean isNotBlank(String arg1) {
        boolean v0;
        if(StringUtils.isBlank(arg1)) {
            v0 = false;
        }
        else {
            v0 = true;
        }

        return v0;
    }

    public static boolean isNotEmpty(String arg1) {
        boolean v0;
        if(StringUtils.isEmpty(arg1)) {
            v0 = false;
        }
        else {
            v0 = true;
        }

        return v0;
    }

    public static String[] parseUrlForCmwap(String arg6) {
        if(StringUtils.isBlank(arg6)) {
            throw new IllegalArgumentException();
        }

        String[] v1 = new String[]{"", ""};
        String v0 = arg6.trim();
        int v2 = v0.indexOf("http://");
        if(v2 >= 0) {
            v0 = v0.substring(v2 + 7);
        }

        v2 = v0.indexOf("/");
        if(v2 > 0) {
            v1[0] = v0.substring(0, v2);
            v1[1] = v0.substring(v2);
        }
        else {
            v1[0] = v0;
            v1[1] = "/";
        }

        LogUtils.d("BaseLib", "StringUtils.parseUrlForCmwap() => domain:" + v1[0] + " | path:" + v1[
                1]);
        return v1;
    }

    public static String removeUrlParams(String arg2) {
        if(StringUtils.isBlank(arg2)) {
            throw new IllegalArgumentException();
        }

        int v0 = arg2.indexOf("?");
        if(v0 >= 0) {
            arg2 = arg2.substring(0, v0);
        }

        return arg2;
    }
}
