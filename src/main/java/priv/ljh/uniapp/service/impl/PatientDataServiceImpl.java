package priv.ljh.uniapp.service.impl;

import priv.ljh.uniapp.entity.BladderData;
import priv.ljh.uniapp.entity.PatientData;
import priv.ljh.uniapp.mapper.PatientDataMapper;
import priv.ljh.uniapp.service.PatientDataService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import priv.ljh.utils.MyPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * 病患资料表 服务实现类
 * </p>
 *
 * @author lijinghai
 * @since 2021-06-01
 */
@Service
public class PatientDataServiceImpl extends ServiceImpl<PatientDataMapper, PatientData> implements PatientDataService {

    @Override
    public MyPage searchPatientData(int pageNo, int limit, String idSorted, List<PatientData> patientData) {
        MyPage page = null;
        List<PatientData> patientDataList = new ArrayList<>();
        patientDataList.addAll(patientData);
        if(idSorted != null && idSorted.startsWith("-")){
            Collections.reverse(patientDataList);
        }
        int total = patientDataList.size();
        int maxPageNo = patientDataList.size()%limit == 0? patientDataList.size()/limit:patientDataList.size()/limit + 1;
        if(pageNo>maxPageNo){
            pageNo = maxPageNo;
        }
        int beginIndex = (pageNo-1)*limit;
        int endIndex = pageNo*limit;
        if(endIndex>total){
            endIndex = total;
        }

        page = new MyPage(patientDataList.subList(beginIndex, endIndex), total);

        return page;
    }
}
