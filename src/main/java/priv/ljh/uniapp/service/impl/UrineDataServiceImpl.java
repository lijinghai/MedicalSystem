package priv.ljh.uniapp.service.impl;

import priv.ljh.uniapp.entity.BladderData;
import priv.ljh.uniapp.entity.UrineData;
import priv.ljh.uniapp.mapper.UrineDataMapper;
import priv.ljh.uniapp.service.UrineDataService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import priv.ljh.utils.MyPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 尿常规数据 服务实现类
 * </p>
 *
 * @author lijinghai
 * @since 2021-06-03
 */
@Service
public class UrineDataServiceImpl extends ServiceImpl<UrineDataMapper, UrineData> implements UrineDataService {

    @Override
    public MyPage searchUrineData(int pageNo, int limit, String idSorted, List<UrineData> urineData) {
        MyPage page = null;
        List<UrineData> urineDataList = new ArrayList<>();
        urineDataList.addAll(urineData);
        if(idSorted != null && idSorted.startsWith("-")){
            Collections.reverse(urineDataList);
        }
        int total = urineDataList.size();
        int maxPageNo = urineDataList.size()%limit == 0? urineDataList.size()/limit:urineDataList.size()/limit + 1;
        if(pageNo>maxPageNo){
            pageNo = maxPageNo;
        }
        int beginIndex = (pageNo-1)*limit;
        int endIndex = pageNo*limit;
        if(endIndex>total){
            endIndex = total;
        }

        page = new MyPage(urineDataList.subList(beginIndex, endIndex), total);

        return page;
    }

    @Override
    public MyPage searchUrineDataById(int pageNo, int limit, String idSorted, List<Map> info) {
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
