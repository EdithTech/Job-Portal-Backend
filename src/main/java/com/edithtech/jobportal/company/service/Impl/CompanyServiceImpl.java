package com.edithtech.jobportal.company.service.Impl;

import com.edithtech.jobportal.dto.CompanyDto;
import com.edithtech.jobportal.entity.Company;
import com.edithtech.jobportal.repository.CompanyRepository;
import com.edithtech.jobportal.company.service.ICompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements ICompanyService {

    private final CompanyRepository companyRepository;

//    @Autowired // optional as only single contructor is there
//    public CompanyServiceImpl(CompanyRepository companyRepository){
//        this.companyRepository = companyRepository;
//    }

    @Override
    public List<CompanyDto> getAllCompanies() {
        List<Company> companyList = companyRepository.findAll();

        List<CompanyDto> companyDtoList = new ArrayList<>();
        for (Company company : companyList) {
            companyDtoList.add(transferToDto(company));
        }
        return companyDtoList;
//        return companyList.stream().map(this::transferToDto).collect(Collectors.toList());
    }

    private CompanyDto transferToDto(Company company){
        return new CompanyDto(company.getId(), company.getName(), company.getLogo(), company.getIndustry(), company.getSize(), company.getRating(),
                                company.getLocations(), company.getFounded(), company.getDescription(), company.getEmployees(),
                                company.getWebsite(), company.getCreatedAt());
    }
}
