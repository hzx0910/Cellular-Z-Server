package com.cellular.z.server.models;

import com.opencsv.bean.CsvBindByName;

/**
 * CELL INFO WITH SIGNAL STRENGTH AND LOCATION 小区信息，包含信号质量位置信息
 * <p/>除type外其他字段都可能为空
 * <p/>https://hzx0910.github.io/cellular-doc/2022/07/28/CELL.html
 * <p>
 * columns 列:
 * "TIME","LATITUDE","LONGITUDE","TYPE",
 * "NR-TAC","NR-PCI","NR-CI","NR-ARFCN","CSI-RSRP","CSI-RSRQ","CSI-SINR","SS-RSRP","SS-RSRQ","SS-SINR",
 * "TAC","PCI","ECI","EARFCN","BAND_WIDTH","RSSI","RSRP","RSRQ","SINR","CQI",
 * "LAC","CI","RXLEV","ARFCN","BSIC","PSC","UARFCN",
 * "NID","BID","SID","CDMADBM","CDMAECIO","EVDODBM","EVDOECIO","EVDOSNR"
 */
public class CellState extends Cell {
    @CsvBindByName
    public String time;
    @CsvBindByName
    public String latitude;
    @CsvBindByName
    public String longitude;
}