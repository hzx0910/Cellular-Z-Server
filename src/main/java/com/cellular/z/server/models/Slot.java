package com.cellular.z.server.models;

import java.beans.Transient;
import java.util.List;

/**
 * SLOT INFO 卡槽状态信息
 * <p/>https://hzx0910.github.io/cellular-doc/2022/07/28/MAIN.html
 */
public class Slot {
    /**
     * 卡槽号
     */
    public int slot_sn;
    /**
     * 默认语音卡槽 1是0否 1yes 0no
     */
    public int is_voice_slot;
    /**
     * 默认数据卡槽 1是0否 1yes 0no
     */
    public int is_data_slot;

    public String imei;
    public String imsi;
    public String iccid;
    /**
     * SIM运营商（可能为虚拟运营商）
     */
    public String simoperator;
    public String msisdn;
    public String mcc;
    public String mnc;
    /**
     * 网络运营商
     */
    public String netoperator;
    /**
     * 数据网络类型
     */
    public String datanet;
    /**
     * 语音网络类型
     */
    public String voicenet;
    /**
     * 服务小区
     */
    public Cell cell = new Cell();
    /**
     * 邻小区列表
     */
    public List<Cell> ncells;

    /***
     * 网络是否中国移动 46020 中国动车和高铁的调度网，是移动的GSM-R铁路专网
     */
    @Transient
    public boolean isCMCC() {
        if (mcc != null && mcc.equals("460") && mnc != null) {
            if (mnc.equals("00") || mnc.equals("02") || mnc.equals("04") || mnc.equals("07") || mnc.equals("08") || mnc.equals("20")) {
                return true;
            }
        }
        return false;
    }

    /***
     * 网络是否中国电信
     */
    @Transient
    public boolean isCNCC() {
        if (mcc != null && mcc.equals("460") && mnc != null) {
            if (mnc.equals("03") || mnc.equals("05") || mnc.equals("11")) {
                return true;
            }
        }
        return false;
    }

    /***
     * 网络是否中国联通
     */
    @Transient
    public boolean isCUCC() {
        if (mcc != null && mcc.equals("460") && mnc != null) {
            if (mnc.equals("01") || mnc.equals("06") || mnc.equals("09")) {
                return true;
            }
        }
        return false;
    }

    /***
     * 网络是否中国广电
     */
    @Transient
    public boolean isCBN() {
        if (mcc != null && mcc.equals("460") && mnc != null) {
            if (mnc.equals("13") || mnc.equals("15")) {
                return true;
            }
        }
        return false;
    }

}