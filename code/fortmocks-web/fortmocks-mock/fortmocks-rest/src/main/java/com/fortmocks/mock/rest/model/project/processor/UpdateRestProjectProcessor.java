/*
 * Copyright 2015 Karl Dahlgren
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fortmocks.mock.rest.model.project.processor;

import com.fortmocks.core.model.Processor;
import com.fortmocks.core.model.Result;
import com.fortmocks.core.model.Task;
import com.fortmocks.mock.rest.model.project.dto.RestProjectDto;
import com.fortmocks.mock.rest.model.project.processor.message.input.UpdateRestProjectInput;
import com.fortmocks.mock.rest.model.project.processor.message.output.UpdateRestProjectOutput;
import org.springframework.stereotype.Service;

/**
 * @author Karl Dahlgren
 * @since 1.0
 */
@Service
public class UpdateRestProjectProcessor extends AbstractRestProjectProcessor implements Processor<UpdateRestProjectInput, UpdateRestProjectOutput> {

    /**
     * The process message is responsible for processing an incoming task and generate
     * a response based on the incoming task input
     * @param task The task that will be processed by the processor
     * @return A result based on the processed incoming task
     * @see Task
     * @see Result
     */
    @Override
    public Result<UpdateRestProjectOutput> process(final Task<UpdateRestProjectInput> task) {
        final UpdateRestProjectInput input = task.getInput();
        final Long restProjectId = input.getRestProjectId();
        final RestProjectDto restProject = input.getRestProject();
        final RestProjectDto updatedRestProject = update(restProjectId, restProject);
        final UpdateRestProjectOutput output = new UpdateRestProjectOutput();
        output.setUpdatedRestProject(updatedRestProject);
        return createResult(output);
    }
}