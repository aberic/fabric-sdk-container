package cn.aberic.fabric.service;

import cn.aberic.fabric.mapper.ChaincodeMapper;
import cn.aberic.fabric.utils.DateUtil;
import cn.aberic.thrift.chaincode.ChaincodeInfo;
import cn.aberic.thrift.chaincode.ChaincodeService;
import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("chaincodeService")
public class ChaincodeServiceImpl implements ChaincodeService.Iface {

    @Resource
    private ChaincodeMapper chaincodeMapper;

    @Override
    public int add(ChaincodeInfo chaincodeInfo) throws TException {
        chaincodeInfo.setDate(DateUtil.getCurrent("yyyy年MM月dd日"));
        return chaincodeMapper.add(chaincodeInfo);
    }

    @Override
    public int update(ChaincodeInfo chaincodeInfo) throws TException {
        return chaincodeMapper.update(chaincodeInfo);
    }

    @Override
    public List<ChaincodeInfo> listAll() throws TException {
        return chaincodeMapper.listAll();
    }

    @Override
    public List<ChaincodeInfo> listById(int id) throws TException {
        return chaincodeMapper.list(id);
    }

    @Override
    public ChaincodeInfo get(int id) throws TException {
        return chaincodeMapper.get(id);
    }

    @Override
    public int countById(int id) throws TException {
        return chaincodeMapper.count(id);
    }

    @Override
    public int count() throws TException {
        return chaincodeMapper.countAll();
    }
}