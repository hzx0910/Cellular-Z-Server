package com.cellular.z.server.controller;

import com.cellular.z.server.models.CellState;
import com.cellular.z.server.models.Headers;
import com.cellular.z.server.models.Slot;
import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

/**
 * data upload interface 数据上报相关接口
 */
@Slf4j
@Validated
@RestController
@RequestMapping(value = "/upload")
public class CollectController {
    Gson gson = new Gson();

    /**
     * json upload interface 上传接口
     * Content-Type=application/json
     * http://ip:port/upload/json
     * doc https://hzx0910.github.io/cellular-doc/2022/07/28/JSON.html
     *
     * @Params header {
     * "x-client-type": "Android",
     * "version-name": "6.3.5",
     * "cell-vip-id": "Mq9rq7Ie",
     * "slot-index": "1",
     * "operator": "46000",
     * "uuid": "525c2463-ace2-4ef5-81b1-5eb962fef5f9",
     * "content-type": "application/json; charset\u003dutf-8",
     * "content-length": "586",
     * "host": "192.168.124.18:8088",
     * "connection": "Keep-Alive",
     * "accept-encoding": "gzip",
     * "user-agent": "okhttp/3.12.12"
     * }
     */
    @RequestMapping(value = "/json")
    public String upload(@RequestHeader Map<String, String> headers, @RequestBody Slot slot) {
        log.error("upload headers:{}", headers.get(Headers.cell_vip_id) + "->" + gson.toJson(headers));
        log.error("          slot:{}", gson.toJson(slot));
        //todo: save db or save file
        return "{\"status\":\"ok\"}";
    }

    /**
     * csv upload interface 上传接口
     * Content-Type=text/plain
     * sample http://ip:port/upload/csv
     * doc https://hzx0910.github.io/cellular-doc/2022/07/28/CSV.html
     *
     * @Params header {
     * "x-client-type": "Android",
     * "version-name": "6.3.5",
     * "cell-vip-id": "Mq9rq7Ie",
     * "slot-index": "1",
     * "operator": "46000",
     * "uuid": "525c2463-ace2-4ef5-81b1-5eb962fef5f9",
     * "content-type": "text/plain; charset\u003dutf-8",
     * "content-length": "586",
     * "host": "192.168.124.18:8088",
     * "connection": "Keep-Alive",
     * "accept-encoding": "gzip",
     * "user-agent": "okhttp/3.12.12"
     * }
     */
    @RequestMapping(value = "/csv")
    public String report(@RequestHeader Map<String, String> headers, @RequestBody String csv) {
        log.error("report headers:{}", gson.toJson(headers));

        HeaderColumnNameMappingStrategy<CellState> strategy = new HeaderColumnNameMappingStrategy<>();
        strategy.setType(CellState.class);
        CsvToBean<CellState> build = new CsvToBeanBuilder<CellState>(new StringReader(csv)).withMappingStrategy(strategy).build();
        List<CellState> list = build.parse();
        log.error("           csv:{}", gson.toJson(list.get(0)));
        //todo: save db or save file
        return "{\"status\":\"ok\"}";
    }
}
