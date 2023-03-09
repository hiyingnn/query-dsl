package com.example.querydsldemo.career;


import com.example.querydsldemo.career.domain.CareerHistory;
import com.example.querydsldemo.career.domain.QCareerHistory;
import com.example.querydsldemo.career.dto.CareerHistoryDTO;
import com.example.querydsldemo.career.dto.ClassDTO;
import com.example.querydsldemo.career.dto.RecordDTO;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@Slf4j
@RequestMapping("/api/v1/career")
@RequiredArgsConstructor
public class CareerController {

    private final CareerHistoryService careerHistoryService;

    @GetMapping
    public List<CareerHistoryDTO> getAllRecords() {
        return careerHistoryService.getAllRecords();
    }

  @GetMapping("{profileId}/query-dsl-custom")
  public Page<CareerHistoryDTO> getByCompanyName(@RequestParam String companyName, @PathVariable Long profileId, Pageable pageable) {
    return careerHistoryService.getByCompanyName(companyName, pageable);
  }

  @GetMapping("{profileId}/query-dsl-variable")
  public Page<CareerHistoryDTO> getByCompanyName( @ParameterObject @QuerydslPredicate(root = CareerHistory.class, bindings = CareerHistoryQueryDslRepository.class) Predicate searchPredicate,
                                                 @PathVariable Long profileId,
                                                  @ParameterObject Pageable pageable) {
    var composedPredicate = ExpressionUtils.allOf(searchPredicate, QCareerHistory.careerHistory.profileId.eq(profileId));
    return careerHistoryService.getByQueryDslPredicate(composedPredicate, pageable);
  }
  @GetMapping("/{id}")
    public Optional<CareerHistoryDTO> getOneRecord(@PathVariable String id) {
        return careerHistoryService.getRecordById(id);
    }

    @PostMapping
    public CareerHistoryDTO addRecord(@RequestBody @Valid CareerHistoryDTO careerHistoryDTO) {
        return careerHistoryService.addRecord(careerHistoryDTO);
    }

  @PostMapping("/record")
  public RecordDTO addRecord(@RequestBody RecordDTO recordDTO) {
    log.info(recordDTO.string());
    return recordDTO;
  }

  @PostMapping("/class")
  public ClassDTO addRecord(@RequestBody ClassDTO classDTO) {
    log.info(classDTO.toString());
    return classDTO;
  }

    @PutMapping("/{id}")
    public CareerHistoryDTO updateRecord(@PathVariable String id, @RequestBody @Valid CareerHistoryDTO careerHistoryDTO) {
        return careerHistoryService.updateRecord(id, careerHistoryDTO);
    }

}
