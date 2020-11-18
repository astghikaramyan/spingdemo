package am.bdgjpasping.service.serviceimpl;



import am.bdgjpasping.entity.CompanyEntity;
import am.bdgjpasping.repository.CompanyRepo;
import am.bdgjpasping.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by User on 17.09.2020.
 */
@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepo companyRepo;

    @Autowired
    public CompanyServiceImpl(CompanyRepo companyRepo) {

        this.companyRepo = companyRepo;
    }

    @Override
    public Optional<CompanyEntity> getById(long id){
            return this.companyRepo.findById(id);
    }

    @Override
    public Set<CompanyEntity> getAll() {
        List<CompanyEntity> companyEntityList = companyRepo.findAll();
        if(companyEntityList != null){
            Set<CompanyEntity> companies = new HashSet<>();
            for(CompanyEntity c : companyEntityList){
                companies.add(c);
            }
            return companies;
        }
        return null;
    }

    @Override
    public Set<CompanyEntity> get(int page, int perPage, String sort)  {
        Set<CompanyEntity> companies = new LinkedHashSet<>();
        Page<CompanyEntity> companyPage = this.companyRepo.
                findAll(PageRequest.of(page, perPage, Sort.sort(sort.getClass())));
        for(CompanyEntity p : companyPage){
            companies.add(p);
        }
        return companies;
    }

    @Override
    public CompanyEntity save(CompanyEntity companyEntity) {
            return companyRepo.save(companyEntity);
    }

    @Override
    public CompanyEntity update(CompanyEntity companyEntity) {
            return companyRepo.save(companyEntity);
    }

    @Override
    public void delete(long companyId){
        Optional<CompanyEntity> company = companyRepo.findById(companyId);
        if(company.isPresent()){
            CompanyEntity companyEntity1 = company.get();
            companyEntity1.setComapnyId(companyId);
            companyRepo.delete(companyEntity1);
        }
    }
}
