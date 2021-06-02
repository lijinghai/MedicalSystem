package priv.ljh.uniapp.controller;


import cn.hutool.core.util.RandomUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import priv.ljh.uniapp.entity.BladderData;
import priv.ljh.uniapp.mapper.BladderDataMapper;
import priv.ljh.uniapp.service.BladderDataService;
import priv.ljh.utils.Constants;
import priv.ljh.utils.MyPage;
import priv.ljh.utils.ResultResponse;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 膀胱动力学资料 前端控制器
 * </p>
 *
 * @author lijinghai
 * @since 2021-05-31
 */
@Api(tags = {"膀胱动力学资料信息控制类"})
@Slf4j
@RestController
@RequestMapping("/bladderData")
public class BladderDataController {

    @Autowired
    private BladderDataMapper bladderDataMapper;

    @Autowired
    private BladderDataService bladderDataService;

    @ApiOperation("增加一条信息")
    @PostMapping
    public ResultResponse create(@RequestBody BladderData bladderData){
        ResultResponse res = null;
        int id = RandomUtil.randomInt(10000);
//        bladderDataMapper.insert(bladderData);
        bladderDataMapper.insertBladder();
        bladderData.getId();
        log.info("id========>"+bladderData.getId());
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, bladderData);
        return res;
    }


    @ApiOperation("根据id删除一条信息")
    @PostMapping("/delete")
    public ResultResponse deleteBladderData (@RequestParam("id") Integer id){
        ResultResponse res = null;
        int result = bladderDataMapper.deleteById(id);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, id);
        return res;
    }

    @ApiOperation("修改一条信息")
    @PutMapping
    public ResultResponse updateBladderData(@RequestBody BladderData bladderData){
        ResultResponse res = null;
        bladderDataMapper.updateById(bladderData);
        Integer id1 = bladderData.getId();
        Integer id2 = bladderData.getPatientDataId();
        log.info("bladderData.getId()=======>"+bladderData.getId());
        log.info("bladderData.getPatientDataId()======>"+bladderData.getPatientDataId());
        bladderDataMapper.updateBladder(id1,id2);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, bladderData);
        return res;
    }


    @ApiOperation("查询所有信息")
    @GetMapping
    public ResultResponse queryBladderData(@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        List<BladderData> bladderData = bladderDataMapper.selectList(null);
        log.info("bladderData====>"+bladderData);
        MyPage page = this.bladderDataService.searchBladderData(pageNo, limit, idSort,bladderData);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, page);
        return res;
    }

    @ApiOperation("根据id查询信息")
    @GetMapping("/id")
    public ResultResponse queryBladderDataById(@RequestParam("id") Integer id,@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        List<Map> info = bladderDataMapper.infoBladder(id);
        log.info("info====>"+info);
        MyPage page = this.bladderDataService.searchBladderDataById(pageNo, limit, idSort,info);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK,page);
        return res;
    }

}

