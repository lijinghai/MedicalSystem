package priv.ljh.uniapp.service.impl;

import priv.ljh.uniapp.entity.Events;
import priv.ljh.uniapp.mapper.EventsMapper;
import priv.ljh.uniapp.service.EventsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import priv.ljh.utils.MyPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * 事件表 服务实现类
 * </p>
 *
 * @author lijinghai
 * @since 2021-06-04
 */
@Service
public class EventsServiceImpl extends ServiceImpl<EventsMapper, Events> implements EventsService {

    @Override
    public MyPage searchPcCarousel(int pageNo, int limit, String idSorted, List<Events> events) {
        MyPage page = null;
        List<Events> eventsList = new ArrayList<>();
        eventsList.addAll(events);
        if(idSorted != null && idSorted.startsWith("-")){
            Collections.reverse(eventsList);
        }
        int total = eventsList.size();
        int maxPageNo = eventsList.size()%limit == 0? eventsList.size()/limit:eventsList.size()/limit + 1;
        if(pageNo>maxPageNo){
            pageNo = maxPageNo;
        }
        int beginIndex = (pageNo-1)*limit;
        int endIndex = pageNo*limit;
        if(endIndex>total){
            endIndex = total;
        }

        page = new MyPage(eventsList.subList(beginIndex, endIndex), total);

        return page;
    }
}
