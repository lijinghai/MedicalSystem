package priv.ljh.uniapp.service;

import priv.ljh.uniapp.entity.RenalData;
import priv.ljh.uniapp.entity.UreteralData;
import com.baomidou.mybatisplus.extension.service.IService;
import priv.ljh.utils.MyPage;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 输尿管B超数据资料 服务类
 * </p>
 *
 * @author lijinghai
 * @since 2021-06-04
 */
public interface UreteralDataService extends IService<UreteralData> {

    /**
     * 自定义分页查询方法
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param ureteralData
     * @return
     */
    public MyPage searchUreteralData(int pageNo, int limit, String idSorted, List<UreteralData> ureteralData);


    /**
     * 根据id查询
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param info
     * @return
     */
    public MyPage searchUreteralDataById(int pageNo, int limit, String idSorted, List<Map> info);
}
