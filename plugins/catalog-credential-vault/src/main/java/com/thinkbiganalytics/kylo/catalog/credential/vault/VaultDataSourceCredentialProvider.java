/**
 *
 */
package com.thinkbiganalytics.kylo.catalog.credential.vault;

/*-
 * #%L
 * kylo-catalog-credential-simple
 * %%
 * Copyright (C) 2017 - 2018 ThinkBig Analytics, a Teradata Company
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.thinkbiganalytics.kylo.catalog.credential.spi.AbstractDataSourceCredentialProvider;
import com.thinkbiganalytics.kylo.catalog.rest.model.DataSource;

import java.util.Optional;

import javax.inject.Inject;

import lombok.extern.slf4j.Slf4j;

/**
 * Credential provider which stores credentials in Vault
 */
public class VaultDataSourceCredentialProvider extends AbstractDataSourceCredentialProvider {

    @Inject
    private SecretStore secretStore;

    @Override
    public boolean accepts(DataSource ds) {
        return secretStore.contains(ds.getId());
    }

    @Override
    protected Optional<Credentials> getCredentials(DataSource ds) {
        Credentials c = secretStore.read(ds.getId());
        return Optional.ofNullable(c);
    }
}
