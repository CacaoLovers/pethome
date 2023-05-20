package ru.itis.pethome.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.pethome.dao.MissingDao;
import ru.itis.pethome.dto.request.MissingRequest;
import ru.itis.pethome.dto.response.MissingResponse;
import ru.itis.pethome.mappers.MissingMapper;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MissingServiceImpl implements MissingService {

    private final MissingDao missingDao;
    private final MissingMapper missingMapper;

    @Override
    public MissingResponse createMissing(MissingRequest missingRequest) {
        return missingMapper.toResponse(missingDao.save(missingMapper.toEntity(missingRequest)));
    }

    @Override
    public MissingResponse updateMissing(MissingRequest missingRequest) {
        return null;
    }

    @Override
    public void deleteMissing(UUID uuid) {

    }

    @Override
    public MissingResponse getMissingById(UUID uuid) {
        return null;
    }

    @Override
    public List<MissingResponse> getMissingList() {
        return null;
    }

    @Override
    public List<MissingResponse> getMissingPageableList(int page) {
        return null;
    }
}
