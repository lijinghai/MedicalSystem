package priv.ljh.uniapp.service;

import priv.ljh.uniapp.entity.BladderData;
import priv.ljh.uniapp.entity.UrineData;
import com.baomidou.mybatisplus.extension.service.IService;
import priv.ljh.utils.MyPage;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 尿常规数据 服务类
 * </p>
 *
 * @author lijinghai
 * @since 2021-06-03
 */
public interface UrineDataService extends IService<UrineData> {
    /**
     * 自定义分页查询方法
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param urineData
     * @return
     */
    public MyPage searchUrineData(int pageNo, int limit, String idSorted, List<UrineData> urineData);


    /**
     * 根据id查询
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param info
     * @return
     */
    public MyPage searchUrineDataById(int pageNo, int limit, String idSorted, List<Map> info);
}
