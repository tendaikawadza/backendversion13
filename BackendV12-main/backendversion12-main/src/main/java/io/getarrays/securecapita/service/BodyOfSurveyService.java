package io.getarrays.securecapita.service;

import io.getarrays.securecapita.domain.DeputyHeadAdministrationRequisition;

public interface BodyOfSurveyService {
    DeputyHeadAdministrationRequisition createDeputyHeadAdministrationRequisition
            (DeputyHeadAdministrationRequisition deputyHeadAdministrationRequisition, Long userId);
}
