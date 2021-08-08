package priv.ljh.uniapp.controller;


import cn.hutool.core.util.RandomUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import priv.ljh.uniapp.entity.BladderData;
import priv.ljh.uniapp.entity.UrineData;
import priv.ljh.uniapp.entity.User;
import priv.ljh.uniapp.mapper.UrineDataMapper;
import priv.ljh.uniapp.service.UrineDataService;
import priv.ljh.utils.Constants;
import priv.ljh.utils.MyPage;
import priv.ljh.utils.ResultResponse;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 尿常规数据 前端控制器
 * </p>
 *
 * @author lijinghai
 * @since 2021-06-03
 */
@Api(tags = {"尿常规数据信息控制类"})
@Slf4j
@RestController
@RequestMapping("/urineData")
public class UrineDataController {

    @Autowired
    private UrineDataMapper urineDataMapper;

    @Autowired
    private UrineDataService urineDataService;

    @ApiOperation("增加一条信息")
    @PostMapping
    public ResultResponse create(@RequestBody UrineData urineData,HttpServletRequest request){
        ResultResponse res = null;
        int id = RandomUtil.randomInt(10000);
        //获取user_id
        ServletContext context= request.getServletContext();

        // 获取
        int id1 = (int) context.getAttribute("id");
        urineDataMapper.insertUrine(id1);
        urineData.getId();
        log.info("id========>"+urineData.getId());
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, urineData);
        return res;
    }

    @ApiOperation("根据id增加一条信息")
    @PostMapping("/id")
    public ResultResponse create(@RequestBody BladderData bladderData, HttpServletRequest request, @RequestParam("id") Integer id){
        ResultResponse res = null;

        urineDataMapper.insertUrine(id);
        bladderData.getId();
        log.info("id========>"+bladderData.getId());
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, bladderData);
        return res;
    }


    @ApiOperation("根据id删除一条信息")
    @PostMapping("/delete")
    public ResultResponse deleteUrineData (@RequestParam("id") Integer id){
        ResultResponse res = null;
        int result = urineDataMapper.deleteById(id);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, id);
        return res;
    }

    @ApiOperation("修改一条信息")
    @PutMapping
    public ResultResponse updateUrineData(@RequestBody UrineData urineData){
        ResultResponse res = null;
        urineDataMapper.updateById(urineData);
        Integer id1 = urineData.getId();
        log.info("urineData.getId()=======>"+urineData.getId());
        urineDataMapper.updateUrine(id1,id1);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, urineData);
        return res;
    }


    @ApiOperation("查询所有信息")
    @GetMapping
    public ResultResponse queryUrineData(@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort,HttpServletRequest request){
        ResultResponse res = null;
        //获取user_id
        ServletContext context= request.getServletContext();

        // 获取
        int id1 = (int) context.getAttribute("id");
        List<UrineData> urineData = urineDataMapper.selectAll(id1);
        log.info("urineData====>"+urineData);
        MyPage page = this.urineDataService.searchUrineData(pageNo, limit, idSort,urineData);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, page);
        return res;
    }

    @ApiOperation("根据id查询信息")
    @GetMapping("/id")
    public ResultResponse queryUrineDataById(HttpServletRequest request,@RequestParam("id") Integer id,@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        List<Map> info = urineDataMapper.infoUrine(id);
        log.info("info====>"+info);
        MyPage page = this.urineDataService.searchUrineDataById(pageNo, limit, idSort,info);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK,page);


        //获取user_id
        ServletContext context= request.getServletContext();

        // 获取
        int id1 = (int) context.getAttribute("id");

        log.info("user id======>"+ id1);

        return res;

    }

}

