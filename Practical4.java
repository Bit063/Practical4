class Practical4 {
  public static int getByte(int num) {
    int Value = num % 256;
    if (Value > 127) {
        Value -= 256;
    } else if (Value < -128) {
        Value += 256;
    }
    return Value;
  }

	
	public static int getShort(int num) {
    int Value = num % 65536;
    if (Value > 32767) {
        Value -= 65536;
    } else if (Value < -32768) {
        Value += 65536;
    }
    return Value;
  }
	
	public static int getNumber(int num, String type) {
   		if (type.toLowerCase().equals("byte")) {
       			return getByte(num); 
    		} 
    		else if (type.toLowerCase().equals("short")) {
        		return getShort(num);
    		} 
    		else {
        		return 0;  
    		}
	}
	
	public static String toxxSystem(String num, String xx) {
        String numberWithoutPrefix = num;
        int decimalValue = 0;

        if (num.startsWith("0x") || num.startsWith("0X")) {
            numberWithoutPrefix = num.substring(2);
            decimalValue = hexadecimalToDecimal(numberWithoutPrefix);
        } else if (num.startsWith("0b") || num.startsWith("0B")) {
            numberWithoutPrefix = num.substring(2);
            decimalValue = binaryToDecimal(numberWithoutPrefix);
        } else if (num.startsWith("0") && num.length() > 1) {
            numberWithoutPrefix = num.substring(1);
            decimalValue = octalToDecimal(numberWithoutPrefix);
        } else {
            decimalValue = Integer.parseInt(num);
        }

        if (xx.equalsIgnoreCase("B")) {
            return decimalToBinary(decimalValue);
        } else if (xx.equalsIgnoreCase("O")) {
            return decimalToOctal(decimalValue);
        } else if (xx.equalsIgnoreCase("D")) {
            return String.valueOf(decimalValue);
        } else if (xx.equalsIgnoreCase("H")) {
            return decimalToHexadecimal(decimalValue);
        } else {
            return "Invalid Number System";
        }
    }

    public static int binaryToDecimal(String binary) {
        int decimal = 0;
        for (int i = 0; i < binary.length(); i++) {
            decimal = decimal * 2 + (binary.charAt(i) - '0');
        }
        return decimal;
    }

    public static int octalToDecimal(String octal) {
        int decimal = 0;
        for (int i = 0; i < octal.length(); i++) {
            decimal = decimal * 8 + (octal.charAt(i) - '0');
        }
        return decimal;
    }

    public static int hexadecimalToDecimal(String hex) {
        int decimal = 0;
        for (int i = 0; i < hex.length(); i++) {
            char ch = hex.charAt(i);
            if (ch >= '0' && ch <= '9') {
                decimal = decimal * 16 + (ch - '0');
            } else if (ch >= 'A' && ch <= 'F') {
                decimal = decimal * 16 + (ch - 'A' + 10);
            } else if (ch >= 'a' && ch <= 'f') {
                decimal = decimal * 16 + (ch - 'a' + 10);
            }
        }
        return decimal;
    }

    public static String decimalToBinary(int decimal) {
        return Integer.toBinaryString(decimal);
    }

    public static String decimalToOctal(int decimal) {
        return Integer.toOctalString(decimal);
    }

    public static String decimalToHexadecimal(int decimal) {
        return Integer.toHexString(decimal).toUpperCase();
    }

    public static void main(String[] args) {
        System.out.println(toxxSystem("0x1A", "D"));
        System.out.println(toxxSystem("0b1010", "H"));
        System.out.println(toxxSystem("012", "D"));
        System.out.println(toxxSystem("25", "B"));
    }
  }
}
