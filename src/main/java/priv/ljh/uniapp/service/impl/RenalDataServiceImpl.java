package priv.ljh.uniapp.service.impl;

import priv.ljh.uniapp.entity.RenalData;
import priv.ljh.uniapp.entity.UrineData;
import priv.ljh.uniapp.mapper.RenalDataMapper;
import priv.ljh.uniapp.service.RenalDataService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import priv.ljh.utils.MyPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 肾功能资料 服务实现类
 * </p>
 *
 * @author lijinghai
 * @since 2021-06-03
 */
@Service
public class RenalDataServiceImpl extends ServiceImpl<RenalDataMapper, RenalData> implements RenalDataService {

    @Override
    public MyPage searchRenalData(int pageNo, int limit, String idSorted, List<RenalData> renalData) {
        MyPage page = null;
        List<RenalData> renalDataList = new ArrayList<>();
        renalDataList.addAll(renalData);
        if(idSorted != null && idSorted.startsWith("-")){
            Collections.reverse(renalDataList);
        }
        int total = renalDataList.size();
        int maxPageNo = renalDataList.size()%limit == 0? renalDataList.size()/limit:renalDataList.size()/limit + 1;
        if(pageNo>maxPageNo){
            pageNo = maxPageNo;
        }
        int beginIndex = (pageNo-1)*limit;
        int endIndex = pageNo*limit;
        if(endIndex>total){
            endIndex = total;
        }

        page = new MyPage(renalDataList.subList(beginIndex, endIndex), total);

        return page;
    }

    @Override
    public MyPage searchRenalDataById(int pageNo, int limit, String idSorted, List<Map> info) {
        MyPage page = null;
        List<Map> infoList = new ArrayList<>();
        infoList.addAll(info);
        if(idSorted != null && idSorted.startsWith("-")){
            Collections.reverse(infoList);
        }
        int total = infoList.size();
        int maxPageNo = infoList.size()%limit == 0? infoList.size()/limit:infoList.size()/limit + 1;
        if(pageNo>maxPageNo){
            pageNo = maxPageNo;
        }
        int beginIndex = (pageNo-1)*limit;
        int endIndex = pageNo*limit;
        if(endIndex>total){
            endIndex = total;
        }

        page = new MyPage(infoList.subList(beginIndex, endIndex), total);

        return page;
    }
}
