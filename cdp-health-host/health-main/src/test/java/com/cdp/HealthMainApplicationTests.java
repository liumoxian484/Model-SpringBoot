package com.cdp;

import com.alibaba.fastjson.JSON;
import com.cdp.common.constant.FwResult;
import com.cdp.common.enums.StatusEnum;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class HealthMainApplicationTests {

    @Test
    void ResultTest() {
        FwResult success = FwResult.success();
        System.out.println(JSON.toJSON(success));

        FwResult error = FwResult.error();
        System.out.println(JSON.toJSON(error));

        List<Object> data = new ArrayList<>();
        data.add("23424");
        FwResult<List<Object>> build = FwResult.build(StatusEnum.ERROR, data);
        System.out.println(JSON.toJSON(build));

        FwResult build1 = FwResult.build(StatusEnum.ERROR, "3333333");
        System.out.println(JSON.toJSON(build1));

        FwResult build2 = FwResult.build(StatusEnum.SUCCESS);
        System.out.println(JSON.toJSON(build2));

        FwResult<List<Object>> build3 = FwResult.build(StatusEnum.ERROR, "32423423", data);
        System.out.println(JSON.toJSON(build3));
    }

}
