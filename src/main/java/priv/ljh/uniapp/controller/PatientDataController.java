package priv.ljh.uniapp.controller;


import cn.hutool.core.util.RandomUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import priv.ljh.uniapp.entity.BladderData;
import priv.ljh.uniapp.entity.PatientData;
import priv.ljh.uniapp.mapper.PatientDataMapper;
import priv.ljh.uniapp.service.PatientDataService;
import priv.ljh.utils.Constants;
import priv.ljh.utils.MyPage;
import priv.ljh.utils.ResultResponse;

import java.util.List;

/**
 * <p>
 * 病患资料表 前端控制器
 * </p>
 *
 * @author lijinghai
 * @since 2021-06-01
 */
@Api(tags = {"病患资料表信息控制类"})
@Slf4j
@RestController
@RequestMapping("/patientdata")
public class PatientDataController {

    @Autowired
    private PatientDataMapper patientDataMapper;
    @Autowired
    private PatientDataService patientDataService;

    @ApiOperation("增加一条信息")
    @PostMapping
    public ResultResponse create(@RequestBody PatientData patientData){
        ResultResponse res = null;
        int id = RandomUtil.randomInt(10000);
        patientDataMapper.insert(patientData);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, patientData);
        return res;
    }


    @ApiOperation("根据id删除一条信息")
    @PostMapping("/delete")
    public ResultResponse deletePatientData (@RequestParam("id") Integer id){
        ResultResponse res = null;
        int result = patientDataMapper.deleteById(id);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, id);
        return res;
    }

    @ApiOperation("修改一条信息")
    @PutMapping
    public ResultResponse updatePatientData (@RequestBody PatientData patientData){
        ResultResponse res = null;
        patientDataMapper.updateById(patientData);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, patientData);
        return res;
    }


    @ApiOperation("查询所有信息")
    @GetMapping
    public ResultResponse queryPatientData (@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        List<PatientData> patientDataList = patientDataMapper.selectList(null);
        log.info("patientDataList====>"+patientDataList);
        MyPage page = this.patientDataService.searchPatientData(pageNo, limit, idSort,patientDataList);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, page);
        return res;
    }

}

