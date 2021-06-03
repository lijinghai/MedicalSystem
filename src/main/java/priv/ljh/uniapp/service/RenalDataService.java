package priv.ljh.uniapp.service;

import priv.ljh.uniapp.entity.RenalData;
import com.baomidou.mybatisplus.extension.service.IService;
import priv.ljh.uniapp.entity.UrineData;
import priv.ljh.utils.MyPage;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 肾功能资料 服务类
 * </p>
 *
 * @author lijinghai
 * @since 2021-06-03
 */
public interface RenalDataService extends IService<RenalData> {

    /**
     * 自定义分页查询方法
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param renalData
     * @return
     */
    public MyPage searchRenalData(int pageNo, int limit, String idSorted, List<RenalData> renalData);


    /**
     * 根据id查询
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param info
     * @return
     */
    public MyPage searchRenalDataById(int pageNo, int limit, String idSorted, List<Map> info);
}