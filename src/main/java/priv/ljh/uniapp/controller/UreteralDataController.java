package priv.ljh.uniapp.controller;


import cn.hutool.core.util.RandomUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import priv.ljh.uniapp.entity.RenalData;
import priv.ljh.uniapp.entity.UreteralData;
import priv.ljh.uniapp.mapper.RenalDataMapper;
import priv.ljh.uniapp.mapper.UreteralDataMapper;
import priv.ljh.uniapp.service.RenalDataService;
import priv.ljh.uniapp.service.UreteralDataService;
import priv.ljh.utils.Constants;
import priv.ljh.utils.MyPage;
import priv.ljh.utils.ResultResponse;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 输尿管B超数据资料 前端控制器
 * </p>
 *
 * @author lijinghai
 * @since 2021-06-04
 */
@Api(tags = {"输尿管B超数据资料信息控制类"})
@Slf4j
@RestController
@RequestMapping("/ureteralData")
public class UreteralDataController {
    @Autowired
    private UreteralDataMapper ureteralDataMapper;

    @Autowired
    private UreteralDataService ureteralDataService;

    @ApiOperation("增加一条信息")
    @PostMapping
    public ResultResponse create(@RequestBody UreteralData ureteralData){
        ResultResponse res = null;
        int id = RandomUtil.randomInt(10000);;
        ureteralDataMapper.insertUreteral();
        ureteralData.getId();
        log.info("id========>"+ureteralData.getId());
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, ureteralData);
        return res;
    }


    @ApiOperation("根据id删除一条信息")
    @PostMapping("/delete")
    public ResultResponse deleteUreteralData (@RequestParam("id") Integer id){
        ResultResponse res = null;
        int result = ureteralDataMapper.deleteById(id);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, id);
        return res;
    }

    @ApiOperation("修改一条信息")
    @PutMapping
    public ResultResponse updateUreteralData(@RequestBody UreteralData ureteralData){
        ResultResponse res = null;
        ureteralDataMapper.updateById(ureteralData);
        Integer id1 = ureteralData.getId();
        log.info("urineData.getId()=======>"+ureteralData.getId());
        ureteralDataMapper.updateUreteral(id1,id1);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, ureteralData);
        return res;
    }


    @ApiOperation("查询所有信息")
    @GetMapping
    public ResultResponse queryUreteralData(@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        List<UreteralData> ureteralData = ureteralDataMapper.selectList(null);
        log.info("ureteralData====>"+ureteralData);
        MyPage page = this.ureteralDataService.searchUreteralData(pageNo, limit, idSort,ureteralData);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, page);
        return res;
    }

    @ApiOperation("根据id查询信息")
    @GetMapping("/id")
    public ResultResponse queryUreteralDataById(@RequestParam("id") Integer id,@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        List<Map> info = ureteralDataMapper.infoUreteral(id);
        log.info("info====>"+info);
        MyPage page = this.ureteralDataService.searchUreteralDataById(pageNo, limit, idSort,info);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK,page);
        return res;
    }
}

