package com.shu.service.impl;

import com.shu.analyzer.Lucene;
import com.shu.analyzer.service.IndexManager;
import com.shu.analyzer.utils.IndexResult;
import com.shu.service.facade.IAnalyzerSearchService;
import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.queryparser.classic.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc on 2017/4/21.
 */
@Service
@Slf4j
public class AnalyzerSearchService implements IAnalyzerSearchService{
    @Autowired
    Lucene lucene;

    @Autowired
    private IndexManager indexManager;

    /**
     * 获取所有文档内容
     * @return
     */
    @Override
    public ArrayList<String> luceneSearch(String str){
        ArrayList<String> res =  new ArrayList<String>();
        try {
            res  = lucene.luceneSearch(str);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public List<String> searchIndex(String str) {

        List<String> indexResultList = indexManager.searchIndex("发展外向型经济");
        return indexResultList;
    }

}
