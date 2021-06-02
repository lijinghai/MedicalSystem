package priv.ljh.uniapp.service;

import priv.ljh.uniapp.entity.BladderData;
import com.baomidou.mybatisplus.extension.service.IService;
import priv.ljh.utils.MyPage;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 膀胱动力学资料 服务类
 * </p>
 *
 * @author lijinghai
 * @since 2021-05-31
 */
public interface BladderDataService extends IService<BladderData> {
    /**
     * 自定义分页查询方法
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param bladderData
     * @return
     */
    public MyPage searchBladderData(int pageNo, int limit, String idSorted, List<BladderData> bladderData);


    /**
     * 根据id查询
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param info
     * @return
     */
    public MyPage searchBladderDataById(int pageNo, int limit, String idSorted, List<Map> info);
}
