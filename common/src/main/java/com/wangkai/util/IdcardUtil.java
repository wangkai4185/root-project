package com.wangkai.util;

import com.wangkai.enums.GenderEnum;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 16/7/11.
 */
public class IdcardUtil {

    /** 中国公民身份证号码最小长度。 */
    public static final int           CHINA_ID_MIN_LENGTH = 15;
    /** 中国公民身份证号码最大长度。 */
    public static final int           CHINA_ID_MAX_LENGTH = 18;
    /** 省、直辖市代码表 */
    public static final String        cityCode[]          = { "11", "12", "13", "14", "15", "21", "22", "23", "31",
            "32", "33", "34", "35", "36", "37", "41", "42", "43", "44", "45", "46", "50", "51", "52", "53", "54", "61",
            "62", "63", "64", "65", "71", "81", "82", "91" };
    /** 每位加权因子 */
    public static final int           power[]             = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
    /** 第18位校检码 */
    public static final String        verifyCode[]        = { "1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2" };
    /** 最低年限 */
    public static final int           MIN                 = 1930;
    public static Map<String, String> provinceCodes           = new HashMap<String, String>();

    static {
        provinceCodes.put("11", "北京");
        provinceCodes.put("12", "天津");
        provinceCodes.put("13", "河北");
        provinceCodes.put("14", "山西");
        provinceCodes.put("15", "内蒙古");
        provinceCodes.put("21", "辽宁");
        provinceCodes.put("22", "吉林");
        provinceCodes.put("23", "黑龙江");
        provinceCodes.put("31", "上海");
        provinceCodes.put("32", "江苏");
        provinceCodes.put("33", "浙江");
        provinceCodes.put("34", "安徽");
        provinceCodes.put("35", "福建");
        provinceCodes.put("36", "江西");
        provinceCodes.put("37", "山东");
        provinceCodes.put("41", "河南");
        provinceCodes.put("42", "湖北");
        provinceCodes.put("43", "湖南");
        provinceCodes.put("44", "广东");
        provinceCodes.put("45", "广西");
        provinceCodes.put("46", "海南");
        provinceCodes.put("50", "重庆");
        provinceCodes.put("51", "四川");
        provinceCodes.put("52", "贵州");
        provinceCodes.put("53", "云南");
        provinceCodes.put("54", "西藏");
        provinceCodes.put("61", "陕西");
        provinceCodes.put("62", "甘肃");
        provinceCodes.put("63", "青海");
        provinceCodes.put("64", "宁夏");
        provinceCodes.put("65", "新疆");
        provinceCodes.put("71", "台湾");
        provinceCodes.put("81", "香港");
        provinceCodes.put("82", "澳门");
        provinceCodes.put("91", "国外");
        //
    }

    /**
     * 将15位身份证号码转换为18位
     *
     * @param idCard
     *            15位身份编码
     * @return 18位身份编码
     */
    public static String conver15CardTo18(String idCard) {
        String idCard18 = "";
        if (idCard.length() != CHINA_ID_MIN_LENGTH) {
            return null;
        }
        if (isNum(idCard)) {
            // 获取出生年月日
            String birthday = idCard.substring(6, 12);
            Date birthDate = null;
            try {
                birthDate = new SimpleDateFormat("yyMMdd").parse(birthday);
            } catch (ParseException e) {
                //
            }
            Calendar cal = Calendar.getInstance();
            if (birthDate != null)
                cal.setTime(birthDate);
            // 获取出生年(完全表现形式,如：2010)
            String sYear = String.valueOf(cal.get(Calendar.YEAR));
            idCard18 = idCard.substring(0, 6) + sYear + idCard.substring(8);
            // 转换字符数组
            char[] cArr = idCard18.toCharArray();
            if (cArr != null) {
                int[] iCard = converCharToInt(cArr);
                int iSum17 = getPowerSum(iCard);
                // 获取校验位
                String sVal = getCheckCode18(iSum17);
                if (sVal.length() > 0) {
                    idCard18 += sVal;
                } else {
                    return null;
                }
            }
        } else {
            return null;
        }
        return idCard18;
    }

    /**
     * 验证18位身份编码是否合法
     *
     * @param idCard
     *            身份编码
     * @return 是否合法
     */
    public static boolean validateIdCard18(String idCard) {
        boolean bTrue = false;
        if (null != idCard && idCard.length() == CHINA_ID_MAX_LENGTH) {
            // 前17位
            String code17 = idCard.substring(0, 17);
            // 第18位
            String code18 = idCard.substring(17, CHINA_ID_MAX_LENGTH);
            if (isNum(code17)) {
                char[] cArr = code17.toCharArray();
                if (cArr != null) {
                    int[] iCard = converCharToInt(cArr);
                    int iSum17 = getPowerSum(iCard);
                    // 获取校验位
                    String val = getCheckCode18(iSum17);
                    if (val.length() > 0) {
                        if (val.equalsIgnoreCase(code18)) {
                            bTrue = true;
                        }
                    }
                }
            }
        }
        return bTrue;
    }

    /**
     * 验证15位身份编码是否合法
     *
     * @param idCard
     *            身份编码
     * @return 是否合法
     */
    public static boolean validateIdCard15(String idCard) {
        if (idCard.length() != CHINA_ID_MIN_LENGTH) {
            return false;
        }
        if (isNum(idCard)) {
            String proCode = idCard.substring(0, 2);
            if (provinceCodes.get(proCode) == null) {
                return false;
            }
            String birthCode = idCard.substring(6, 12);
            Date birthDate = null;
            try {
                birthDate = new SimpleDateFormat("yy").parse(birthCode.substring(0, 2));
            } catch (ParseException e) {
                //
            }
            Calendar cal = Calendar.getInstance();
            if (birthDate != null)
                cal.setTime(birthDate);
            if (!valiDate(cal.get(Calendar.YEAR), Integer.valueOf(birthCode.substring(2, 4)),
                    Integer.valueOf(birthCode.substring(4, 6)))) {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }

    /**
     * 将字符数组转换成数字数组
     *
     * @param ca
     *            字符数组
     * @return 数字数组
     */
    public static int[] converCharToInt(char[] ca) {
        int len = ca.length;
        int[] iArr = new int[len];
        try {
            for (int i = 0; i < len; i++) {
                iArr[i] = Integer.parseInt(String.valueOf(ca[i]));
            }
        } catch (NumberFormatException e) {
           //
        }
        return iArr;
    }

    /**
     * 将身份证的每位和对应位的加权因子相乘之后，再得到和值
     *
     * @param iArr
     * @return 身份证编码。
     */
    public static int getPowerSum(int[] iArr) {
        int iSum = 0;
        if (power.length == iArr.length) {
            for (int i = 0; i < iArr.length; i++) {
                for (int j = 0; j < power.length; j++) {
                    if (i == j) {
                        iSum = iSum + iArr[i] * power[j];
                    }
                }
            }
        }
        return iSum;
    }

    /**
     * 将power和值与11取模获得余数进行校验码判断
     *
     * @param iSum
     * @return 校验位
     */
    public static String getCheckCode18(int iSum) {
        String sCode = "";
        switch (iSum % 11) {
            case 10:
                sCode = "2";
                break;
            case 9:
                sCode = "3";
                break;
            case 8:
                sCode = "4";
                break;
            case 7:
                sCode = "5";
                break;
            case 6:
                sCode = "6";
                break;
            case 5:
                sCode = "7";
                break;
            case 4:
                sCode = "8";
                break;
            case 3:
                sCode = "9";
                break;
            case 2:
                sCode = "x";
                break;
            case 1:
                sCode = "0";
                break;
            case 0:
                sCode = "1";
                break;
        }
        return sCode;
    }

    /**
     * 根据身份编号获取年龄
     *
     * @param idCard
     *            身份编号
     * @return 年龄
     */
    public static int getAgeByIdCard(String idCard) {
        int iAge = 0;
        if (idCard.length() == CHINA_ID_MIN_LENGTH) {
            idCard = conver15CardTo18(idCard);
        }
        String year = idCard.substring(6, 10);
        Calendar cal = Calendar.getInstance();
        int iCurrYear = cal.get(Calendar.YEAR);
        iAge = iCurrYear - Integer.valueOf(year);
        return iAge;
    }

    /**
     * 根据身份编号获取生日
     *
     * @param idCard
     *            身份编号
     * @return 生日(yyyyMMdd)
     */
    public static String getBirthByIdCard(String idCard) {
        Integer len = idCard.length();
        if (len < CHINA_ID_MIN_LENGTH) {
            return null;
        } else if (len == CHINA_ID_MIN_LENGTH) {
            idCard = conver15CardTo18(idCard);
        }
        return idCard.substring(6, 14);
    }

    /**
     * 根据身份编号获取性别
     *
     * @param idCard
     *            身份编号
     * @return 性别枚举
     */
    public static GenderEnum getGenderByIdCard(String idCard) {
        //
        if (idCard.length() == CHINA_ID_MIN_LENGTH) {
            idCard = conver15CardTo18(idCard);
        }
        String sCardNum = idCard.substring(16, 17);
        if (Integer.parseInt(sCardNum) % 2 != 0) {
            return GenderEnum.Male;
        } else {
            return GenderEnum.Female;
        }
    }

    /**
     * 根据身份编号获取户籍省份
     *
     * @param idCard
     *            身份编码
     * @return 省级编码。
     */
    public static String getProvinceByIdCard(String idCard) {
        int len = idCard.length();
        String sProvince = null;
        String sProvinNum = "";
        if (len == CHINA_ID_MIN_LENGTH || len == CHINA_ID_MAX_LENGTH) {
            sProvinNum = idCard.substring(0, 2);
        }
        sProvince = provinceCodes.get(sProvinNum);
        return sProvince;
    }

    /**
     * 根据编号获取户籍省份
     * @param code 编码
     * @return 省级编码。
     */
    public static String getProvinceByCode(String code) {
        //
        if(code.length() < 2){
            return "";
        }

        String sProvinNum = code.substring(0, 2);
        String sProvince = provinceCodes.get(sProvinNum);

        return sProvince;
    }

    /**
     *根据身份证号，自动获取对应的生肖
     *
     * @param idCard
     *            身份证号码
     * @return 生肖
     */
    public static String getZodiacById(String idCard) { // 根据身份证号，自动返回对应的生肖
        //
        String sSX[] = { "猪", "鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊", "猴", "鸡", "狗" };
        int year = getYearByIdCard(idCard);
        int end = 3;
        int x = (year - end) % 12;

        String retValue = "";
        retValue = sSX[x];

        return retValue;
    }

    /**
     * 根据身份编号获取生日年
     *
     * @param idCard
     *            身份编号
     * @return 生日(yyyy)
     */
    public static Short getYearByIdCard(String idCard) {
        Integer len = idCard.length();
        if (len < CHINA_ID_MIN_LENGTH) {
            return null;
        } else if (len == CHINA_ID_MIN_LENGTH) {
            idCard = conver15CardTo18(idCard);
        }
        return Short.valueOf(idCard.substring(6, 10));
    }

    /**
     * 数字验证
     *
     * @param val
     * @return 提取的数字。
     */
    public static boolean isNum(String val) {
        return val == null || "".equals(val) ? false : val.matches("^[0-9]*$");
    }

    /**
     * 验证小于当前日期 是否有效
     *
     * @param iYear
     *            待验证日期(年)
     * @param iMonth
     *            待验证日期(月 1-12)
     * @param iDate
     *            待验证日期(日)
     * @return 是否有效
     */
    public static boolean valiDate(int iYear, int iMonth, int iDate) {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int datePerMonth;
        if (iYear < MIN || iYear >= year) {
            return false;
        }
        if (iMonth < 1 || iMonth > 12) {
            return false;
        }
        switch (iMonth) {
            case 4:
            case 6:
            case 9:
            case 11:
                datePerMonth = 30;
                break;
            case 2:
                boolean dm = ((iYear % 4 == 0 && iYear % 100 != 0) || (iYear % 400 == 0))
                        && (iYear > MIN && iYear < year);
                datePerMonth = dm ? 29 : 28;
                break;
            default:
                datePerMonth = 31;
        }
        return (iDate >= 1) && (iDate <= datePerMonth);
    }
}
