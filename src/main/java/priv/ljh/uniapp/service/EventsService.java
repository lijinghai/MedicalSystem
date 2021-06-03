package priv.ljh.uniapp.service;

import priv.ljh.uniapp.entity.Events;
import com.baomidou.mybatisplus.extension.service.IService;
import priv.ljh.utils.MyPage;

import java.util.List;

/**
 * <p>
 * 事件表 服务类
 * </p>
 *
 * @author lijinghai
 * @since 2021-06-04
 */
public interface EventsService extends IService<Events> {
    /**
     * 自定义分页查询方法
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param events
     * @return
     */
    public MyPage searchPcCarousel(int pageNo, int limit, String idSorted, List<Events> events);

}
