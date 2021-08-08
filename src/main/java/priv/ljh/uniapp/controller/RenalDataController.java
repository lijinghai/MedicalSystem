package priv.ljh.uniapp.controller;


import cn.hutool.core.util.RandomUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import priv.ljh.uniapp.entity.RenalData;
import priv.ljh.uniapp.entity.UreteralData;
import priv.ljh.uniapp.entity.UrineData;
import priv.ljh.uniapp.mapper.RenalDataMapper;
import priv.ljh.uniapp.mapper.UrineDataMapper;
import priv.ljh.uniapp.service.RenalDataService;
import priv.ljh.uniapp.service.UrineDataService;
import priv.ljh.utils.Constants;
import priv.ljh.utils.MyPage;
import priv.ljh.utils.ResultResponse;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 肾功能资料 前端控制器
 * </p>
 *
 * @author lijinghai
 * @since 2021-06-03
 */
@Api(tags = {"肾功能资料信息控制类"})
@Slf4j
@RestController
@RequestMapping("/renalData")
public class RenalDataController {

    @Autowired
    private RenalDataMapper renalDataMapper;

    @Autowired
    private RenalDataService renalDataService;

    @ApiOperation("增加一条信息")
    @PostMapping
    public ResultResponse create(@RequestBody RenalData renalData, HttpServletRequest request){
        ResultResponse res = null;
        int id = RandomUtil.randomInt(10000);
        //获取user_id
        ServletContext context= request.getServletContext();

        // 获取
        int id1 = (int) context.getAttribute("id");
        renalDataMapper.insertRenal(id1);
        renalData.getId();
        log.info("id========>"+renalData.getId());
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, renalData);
        return res;
    }

    @ApiOperation("根据id增加一条信息")
    @PostMapping("/id")
    public ResultResponse create(@RequestBody RenalData renalData, HttpServletRequest request, @RequestParam("id") Integer id){
        ResultResponse res = null;

        renalDataMapper.insertRenal(id);
        renalData.getId();
        log.info("id========>"+renalData.getId());
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, renalData);
        return res;
    }


    @ApiOperation("根据id删除一条信息")
    @PostMapping("/delete")
    public ResultResponse deleteRenalData (@RequestParam("id") Integer id){
        ResultResponse res = null;
        int result = renalDataMapper.deleteById(id);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, id);
        return res;
    }

    @ApiOperation("修改一条信息")
    @PutMapping
    public ResultResponse updateRenalData(@RequestBody RenalData urineData){
        ResultResponse res = null;
        renalDataMapper.updateById(urineData);
        Integer id1 = urineData.getId();
        log.info("urineData.getId()=======>"+urineData.getId());
        renalDataMapper.updateRenal(id1,id1);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, urineData);
        return res;
    }


    @ApiOperation("查询所有信息")
    @GetMapping
    public ResultResponse queryRenalData(HttpServletRequest request,@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        //获取user_id
        ServletContext context= request.getServletContext();

        // 获取
        int id1 = (int) context.getAttribute("id");
        List<RenalData> renalData = renalDataMapper.selectAll(id1);
        log.info("renalData====>"+renalData);
        MyPage page = this.renalDataService.searchRenalData(pageNo, limit, idSort,renalData);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, page);
        return res;
    }

    @ApiOperation("根据id查询信息")
    @GetMapping("/id")
    public ResultResponse queryRenalDataById(@RequestParam("id") Integer id,@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        List<Map> info = renalDataMapper.infoRenal(id);
        log.info("info====>"+info);
        MyPage page = this.renalDataService.searchRenalDataById(pageNo, limit, idSort,info);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK,page);
        return res;
    }
}

