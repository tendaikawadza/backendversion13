package io.getarrays.securecapita.repository.implementation;
import io.getarrays.securecapita.domain.BodyOfSurvey;
import io.getarrays.securecapita.domain.PrincipalAdministratorPurchaseRequisition;
import io.getarrays.securecapita.query.AdminPurchaseQuery;
import io.getarrays.securecapita.query.BodyOfSurveyQuery;
import io.getarrays.securecapita.query.PrincipalAdministratorPurchaseRequisitionQuery;
import io.getarrays.securecapita.repository.BodyOfSurveyRepository;
import io.getarrays.securecapita.repository.PrincipalAdministratorPurchaseRequisitionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class BodyOfSurveyRepositoryImpl implements BodyOfSurveyRepository<BodyOfSurvey> {

    private final NamedParameterJdbcTemplate jdbc;
    public BodyOfSurveyQuery adminPurchaseQuery;
    RowMapper<BodyOfSurvey> rowMapper = (rs, rowNum) -> {
        BodyOfSurvey  bodyOfSurvey = new BodyOfSurvey();
        bodyOfSurvey .setId(rs.getLong("id"));
        bodyOfSurvey .setDate(rs.getDate("date"));
        bodyOfSurvey .setReceiverEmail(rs.getString("receiverEmail"));
        bodyOfSurvey .setSignature(rs.getString("signature"));
        bodyOfSurvey .setUserId(rs.getLong("user_id"));
        return  bodyOfSurvey ;
    };


    @Override
    public BodyOfSurvey create(BodyOfSurvey bodyOfSurvey, Long userId) {
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource parameters = getSqlParameterSource(bodyOfSurvey, userId);
        jdbc.update(BodyOfSurveyQuery.INSERT_BodyOfSurvey_REQUEST_QUERY, parameters, holder);
        return bodyOfSurvey;
    }
    private SqlParameterSource getSqlParameterSource(BodyOfSurvey bodyOfSurvey, Long userId) {
        return new MapSqlParameterSource()
                .addValue("userId",bodyOfSurvey.getUserId())
                .addValue("id",bodyOfSurvey.getId())
                .addValue("date", bodyOfSurvey.getDate())
                .addValue("receiverEmail", bodyOfSurvey.getReceiverEmail())

                .addValue("signature", bodyOfSurvey.getSignature());
    }



}
