package priv.ljh.uniapp.service.impl;

import priv.ljh.uniapp.entity.RenalData;
import priv.ljh.uniapp.entity.UreteralData;
import priv.ljh.uniapp.mapper.UreteralDataMapper;
import priv.ljh.uniapp.service.UreteralDataService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import priv.ljh.utils.MyPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 输尿管B超数据资料 服务实现类
 * </p>
 *
 * @author lijinghai
 * @since 2021-06-04
 */
@Service
public class UreteralDataServiceImpl extends ServiceImpl<UreteralDataMapper, UreteralData> implements UreteralDataService {

    @Override
    public MyPage searchUreteralData(int pageNo, int limit, String idSorted, List<UreteralData> ureteralData) {
        MyPage page = null;
        List<UreteralData> ureteralDataList = new ArrayList<>();
        ureteralDataList.addAll(ureteralData);
        if(idSorted != null && idSorted.startsWith("-")){
            Collections.reverse(ureteralDataList);
        }
        int total = ureteralDataList.size();
        int maxPageNo = ureteralDataList.size()%limit == 0? ureteralDataList.size()/limit:ureteralDataList.size()/limit + 1;
        if(pageNo>maxPageNo){
            pageNo = maxPageNo;
        }
        int beginIndex = (pageNo-1)*limit;
        int endIndex = pageNo*limit;
        if(endIndex>total){
            endIndex = total;
        }

        page = new MyPage(ureteralDataList.subList(beginIndex, endIndex), total);

        return page;
    }

    @Override
    public MyPage searchUreteralDataById(int pageNo, int limit, String idSorted, List<Map> info) {
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
