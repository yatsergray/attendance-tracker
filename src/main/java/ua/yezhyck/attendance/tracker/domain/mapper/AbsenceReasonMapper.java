package ua.yezhyck.attendance.tracker.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.yezhyck.attendance.tracker.domain.dto.AbsenceReasonDto;
import ua.yezhyck.attendance.tracker.domain.dto.editable.AbsenceReasonEditableDto;
import ua.yezhyck.attendance.tracker.domain.entity.AbsenceReason;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AbsenceReasonMapper {

    AbsenceReasonDto mapToAbsenceReasonDto(AbsenceReason absenceReason);

    AbsenceReason mapToAbsenceReason(AbsenceReasonDto absenceReasonDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "lessonStudents", ignore = true)
    AbsenceReason mapToAbsenceReason(AbsenceReasonEditableDto absenceReasonEditableDto);

    List<AbsenceReasonDto> mapAllToAbsenceReasonDtoList(List<AbsenceReason> absenceReasons);
}