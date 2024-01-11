package io.getarrays.securecapita.service.implementation;

import io.getarrays.securecapita.domain.DeputyHeadAdministrationRequisition;
import io.getarrays.securecapita.domain.User;
import io.getarrays.securecapita.repository.DeputyHeadPurchaseRequestRepository;
import io.getarrays.securecapita.repository.UserRepository;
import io.getarrays.securecapita.service.DeputyHeadAdministrationRequisitionService;
import io.getarrays.securecapita.domain.*;
import io.getarrays.securecapita.repository.*;
import io.getarrays.securecapita.domain.User;
import io.getarrays.securecapita.repository.AdminPurchaseRequestsRepository;
import io.getarrays.securecapita.repository.UserRepository;
import io.getarrays.securecapita.service.AdminPurchaseRequisitionService;
import io.getarrays.securecapita.service.DeputyHeadAdministrationRequisitionService;
import io.getarrays.securecapita.service.HeadAdminPurchaseRequisitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import io.getarrays.securecapita.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class HeadAdminPurchaseRequisitionServiceImpl implements HeadAdminPurchaseRequisitionService {

    private final UserRepository<User> userRepository;


    private final HeadAdministrationRepository<HeadAdminPurchaseRequisition> headAdministrationRepository;




    @Override
    public HeadAdminPurchaseRequisition createHeadAdminPurchaseRequisition(HeadAdminPurchaseRequisition headAdminPurchaseRequisition, Long userId) {
        return headAdminPurchaseRequisition.create(


                headAdminPurchaseRequisition, userId);
    }
}