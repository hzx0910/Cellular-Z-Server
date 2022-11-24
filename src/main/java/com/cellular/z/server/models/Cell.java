package com.cellular.z.server.models;

import com.opencsv.bean.CsvBindByName;

/**
 * CELL INFO WITH SIGNAL STRENGTH 小区信息，包含信号质量
 * <p/>除type外其他字段都可能为空 may null
 * <p/>https://hzx0910.github.io/cellular-doc/2022/07/28/CELL.html
 */
public class Cell {
    /**
     * 小区类型
     * <p/>LTE|GSM|WCDMA|TDSCDMA|CDMA|NONE|NR
     * <p/>NONE代表无网络
     */
    @CsvBindByName
    public String type;

    //nr id
    @CsvBindByName(column = "NR-TAC")
    public Integer nr_tac;//16-bit Tracking Area Code
    @CsvBindByName(column = "NR-PCI")
    public Integer nr_pci;//LTE 0..503 NR 0..1007
    @CsvBindByName(column = "NR-CI")
    public Long nci;//[0, 68719476735] or Long.MAX_VALUE 高位 gNB ID http://bbs.eetop.cn/thread-842550-1-1.html
    @CsvBindByName(column = "NR-ARFCN")
    public Integer nrarfcn;//[0, 3279165] or CellInfo#UNAVAILABLE 0x7fffffff
    //nr str
    @CsvBindByName(column = "CSI-RSRP")
    public Integer csi_rsrp;//Range: -140 dBm to -44 dBm.
    @CsvBindByName(column = "CSI-RSRQ")
    public Integer csi_rsrq;//Range: -20 dB to -3 dB.
    @CsvBindByName(column = "CSI-SINR")
    public Integer csi_sinr;//Range: -23 dB to 23 dB
    @CsvBindByName(column = "SS-RSRP")
    public Integer ss_rsrp;//Range: -140 dBm to -44 dBm.
    @CsvBindByName(column = "SS-RSRQ")
    public Integer ss_rsrq;//Range: -20 dB to -3 dB.
    @CsvBindByName(column = "SS-SINR")
    public Integer ss_sinr;//Range: -23 dB to 40 dB

    //lte id
    @CsvBindByName
    public Integer tac;//16-bit Tracking Area Code
    @CsvBindByName
    public Integer pci;//LTE 0..503 NR 0..1007
    @CsvBindByName
    public Integer eci;
    @CsvBindByName
    public Integer earfcn;
    @CsvBindByName(column = "BAND_WIDTH")
    public Integer band_width;//kHz 9.0以上才有
    //lte str
    @CsvBindByName
    public Integer rssi;//系统出的值是正的 -113 + 2 * SignalStrength
    @CsvBindByName
    public Integer rsrp;
    @CsvBindByName
    public Integer rsrq;
    @CsvBindByName
    public Float sinr;//dB
    @CsvBindByName
    public Integer cqi;

    //for gsm|td|wcdma
    @CsvBindByName
    public Integer lac;
    @CsvBindByName
    public Integer ci;
    @CsvBindByName
    public Integer rxlev;
    @CsvBindByName
    public Integer arfcn;
    @CsvBindByName
    public Integer bsic;
    @CsvBindByName
    public Integer psc;//wcdma only
    @CsvBindByName
    public Integer uarfcn;//wcdma only

    //for cdma
    @CsvBindByName
    public Integer nid;
    @CsvBindByName
    public Integer bid;
    @CsvBindByName
    public Integer sid;
    @CsvBindByName
    public Integer cdmadbm;
    @CsvBindByName
    public Float cdmaecio;//dB
    @CsvBindByName
    public Integer evdodbm;
    @CsvBindByName
    public Float evdoecio;//dB
    @CsvBindByName
    public Integer evdosnr;// Valid values are 0-8.  8 is the highest signal-to-noise ratio

}