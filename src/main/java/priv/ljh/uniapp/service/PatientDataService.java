package priv.ljh.uniapp.service;

import priv.ljh.uniapp.entity.BladderData;
import priv.ljh.uniapp.entity.PatientData;
import com.baomidou.mybatisplus.extension.service.IService;
import priv.ljh.utils.MyPage;

import java.util.List;

/**
 * <p>
 * 病患资料表 服务类
 * </p>
 *
 * @author lijinghai
 * @since 2021-06-01
 */
public interface PatientDataService extends IService<PatientData> {

    /**
     * 自定义分页查询方法
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param patientData
     * @return
     */
    public MyPage searchPatientData(int pageNo, int limit, String idSorted, List<PatientData> patientData);
}
