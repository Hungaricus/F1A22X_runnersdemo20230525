package hu.gde.runnersdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class RunnerService {

    private final RunnerRepository runnerRepository;

    @Autowired
    public RunnerService(RunnerRepository runnerRepository) {
        this.runnerRepository = runnerRepository;
    }

    public double getAverageLaptime(Long runnerId) {
        RunnerEntity runner = runnerRepository.findById(runnerId).orElse(null);
        if (runner != null) {
            List<LapTimeEntity> laptimes = runner.getLaptimes();
            int totalTime = 0;
            for (LapTimeEntity laptime : laptimes) {
                totalTime += laptime.getTimeSeconds();
            }
            return (double) totalTime / laptimes.size();
        } else {
            return -1.0;
        }
    }

    public double  getAverageHeight(Model model) {
        List<RunnerEntity> runners = runnerRepository.findAll();
        model.addAttribute("runners", runners);

        if (!runners.isEmpty()) {
            long totalHeight = 0;
            for (RunnerEntity runner : runners) {
                totalHeight += runner.getRunnerHeight();
            }

            double averageHeight = (double) totalHeight / runners.size();
            return averageHeight;
        }else {
            return -1.0;
        }
    }


}
