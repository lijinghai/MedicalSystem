package priv.ljh.uniapp.controller;


import cn.hutool.core.util.RandomUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import priv.ljh.uniapp.entity.Events;
import priv.ljh.uniapp.mapper.EventsMapper;
import priv.ljh.uniapp.service.EventsService;
import priv.ljh.utils.Constants;
import priv.ljh.utils.MyPage;
import priv.ljh.utils.ResultResponse;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 * 事件表 前端控制器
 * </p>
 *
 * @author lijinghai
 * @since 2021-06-04
 */
@Api(tags = {"事件表控制类"})
@Slf4j
@RestController
@RequestMapping("/events")
public class EventsController {
    @Autowired
    private EventsMapper eventsMapper;

    @Autowired
    private EventsService eventsService;

    @ApiOperation("增加一条餐饮事件信息")
    @PostMapping("/first")
    public ResultResponse createFirst(HttpServletRequest request,@RequestBody Events events){
        ResultResponse res = null;
        int id = RandomUtil.randomInt(10000);
        //获取user_id
        ServletContext context= request.getServletContext();

        // 获取
        int id1 = (int) context.getAttribute("id");
        eventsMapper.insertFood(id1);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, events);
        return res;
    }

    @ApiOperation("增加一条导尿事件信息")
    @PostMapping("/second")
    public ResultResponse createSecond(HttpServletRequest request,@RequestBody Events events){
        ResultResponse res = null;
        int id = RandomUtil.randomInt(10000);
        //获取user_id
        ServletContext context= request.getServletContext();

        // 获取
        int id1 = (int) context.getAttribute("id");
        eventsMapper.insertSecond(id1);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, events);
        return res;
    }

    @ApiOperation("增加一条特殊事件信息")
    @PostMapping("/third")
    public ResultResponse createThird(HttpServletRequest request,@RequestBody Events events){
        ResultResponse res = null;
        int id = RandomUtil.randomInt(10000);
        //获取user_id
        ServletContext context= request.getServletContext();

        // 获取
        int id1 = (int) context.getAttribute("id");
        eventsMapper.insertThird(id1);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, events);
        return res;
    }


    @ApiOperation("根据id删除一条数据")
    @PostMapping("/delete")
    public ResultResponse deleteEvents (@RequestParam("id") Integer id){
        ResultResponse res = null;
        int result = eventsMapper.deleteById(id);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, id);
        return res;
    }

    @ApiOperation("修改一条数据")
    @PutMapping
    public ResultResponse updateEvents(@RequestBody Events events){
        ResultResponse res = null;
        eventsMapper.updateById(events);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK, events);
        return res;
    }

    @ApiOperation("查询所有信息")
    @GetMapping
    public ResultResponse queryEvents(@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        List<Events> events = eventsMapper.selectList(null);
        log.info("events====>"+events);
        MyPage page = this.eventsService.searchEvents(pageNo, limit, idSort,events);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK,page);
        return res;
    }

    @ApiOperation("根据id查询信息")
    @GetMapping("/id")
    public ResultResponse queryBladderDataById(@RequestParam("id") Integer id,@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        List<Map> info = eventsMapper.infoEvents(id);
        log.info("info====>"+info);
        MyPage page = this.eventsService.searchEventsById(pageNo, limit, idSort,info);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK,page);
        return res;
    }

    @ApiOperation("查询餐饮事件信息")
    @GetMapping("/first")
    public ResultResponse queryBladderDataByFirst(HttpServletRequest request,@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        //获取user_id
        ServletContext context= request.getServletContext();
        // 获取
        int id1 = (int) context.getAttribute("id");
        List<Map> info = eventsMapper.infoFirst(id1);
        log.info("info====>"+info);
        MyPage page = this.eventsService.searchEventsById(pageNo, limit, idSort,info);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK,page);
        return res;
    }

    @ApiOperation("查询导尿事件信息")
    @GetMapping("/second")
    public ResultResponse queryBladderDataBySecond(HttpServletRequest request,@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        //获取user_id
        ServletContext context= request.getServletContext();

        // 获取
        int id1 = (int) context.getAttribute("id");
        List<Map> info = eventsMapper.infoSecond(id1);
        log.info("info====>"+info);
        MyPage page = this.eventsService.searchEventsById(pageNo, limit, idSort,info);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK,page);
        return res;
    }

    @ApiOperation("查询特殊事件")
    @GetMapping("/third")
    public ResultResponse queryBladderDataByThird(HttpServletRequest request,@RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String idSort){
        ResultResponse res = null;
        //获取user_id
        ServletContext context= request.getServletContext();

        // 获取
        int id1 = (int) context.getAttribute("id");
        List<Map> info = eventsMapper.infoThird(id1);
        log.info("info====>"+info);
        MyPage page = this.eventsService.searchEventsById(pageNo, limit, idSort,info);
        res = new ResultResponse(Constants.STATUS_OK, Constants.MESSAGE_OK,page);
        return res;
    }
}

