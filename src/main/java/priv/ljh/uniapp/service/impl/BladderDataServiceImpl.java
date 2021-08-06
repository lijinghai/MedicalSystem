package priv.ljh.uniapp.service.impl;

import priv.ljh.uniapp.entity.BladderData;
import priv.ljh.uniapp.mapper.BladderDataMapper;
import priv.ljh.uniapp.service.BladderDataService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import priv.ljh.utils.MyPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 膀胱动力学资料 服务实现类
 * </p>
 *
 * @author lijinghai
 * @since 2021-05-31
 */
@Service
public class BladderDataServiceImpl extends ServiceImpl<BladderDataMapper, BladderData> implements BladderDataService {

    @Override
    public MyPage searchBladderData(int pageNo, int limit, String idSorted, List<BladderData> bladderData) {
        MyPage page = null;
        List<BladderData> bladderDataList = new ArrayList<>();
        bladderDataList.addAll(bladderData);
        if(idSorted != null && idSorted.startsWith("-")){
            Collections.reverse(bladderDataList);
        }
        int total = bladderDataList.size();
        int maxPageNo = bladderDataList.size()%limit == 0? bladderDataList.size()/limit:bladderDataList.size()/limit + 1;
        if(pageNo>maxPageNo){
            pageNo = maxPageNo;
        }
        int beginIndex = (pageNo-1)*limit;
        int endIndex = pageNo*limit;
        if(endIndex>total){
            endIndex = total;
        }

        page = new MyPage(bladderDataList.subList(beginIndex, endIndex), total);

        return page;
    }

    @Override
    public MyPage searchBladderDataById(int pageNo, int limit, String idSorted, List<Map> info) {
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
