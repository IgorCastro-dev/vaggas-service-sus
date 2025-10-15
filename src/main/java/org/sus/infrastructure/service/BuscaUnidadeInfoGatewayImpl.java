package org.sus.infrastructure.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.sus.application.gateway.BuscaUnidadeInfoGateway;
import org.sus.domain.unidadeinfo.model.UnidadeInfo;
import org.sus.infrastructure.client.UnidadeInfoClient;

@ApplicationScoped
public class BuscaUnidadeInfoGatewayImpl implements BuscaUnidadeInfoGateway {

    @Inject
    @RestClient
    UnidadeInfoClient unidadeInfoClient;

    @Override
    public UnidadeInfo execute(Long idUnidadeInfo) {
        return unidadeInfoClient.buscaUnidadeInfo(idUnidadeInfo);
    }
}
