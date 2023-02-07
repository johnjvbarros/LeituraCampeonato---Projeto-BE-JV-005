package org.example.Database;

import org.example.Models.Cartao;
import org.example.Models.Estatistica;
import org.example.Models.Gol;
import org.example.Models.Partida;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

interface IDataReader {
    List<Partida> readMatches() throws IOException;

    List<Cartao> readCards() throws IOException;

    List<Estatistica> readStatistics() throws IOException;

    List<Gol> readGoals() throws IOException;
}

public class DataReader implements IDataReader {

    String matchUrl = "src/database/campeonato-brasileiro-full.csv";
    String cardsUrl = "src/database/campeonato-brasileiro-cartoes.csv";
    String statisticsUrl = "src/database/campeonato-brasileiro-estatisticas-full.csv";
    String goalsUrl = "src/database/campeonato-brasileiro-gols.csv";

    private ObjectFactory objectFactory = new ObjectFactory();

    public List<Partida> readMatches() {
        List<Partida> matches = new ArrayList<>();
        try {
            List<String[]> data = Files.lines(Paths.get(matchUrl)).map(line -> line.split(",")).collect(Collectors.toList());

            for (String[] match : data) {
                matches.add(objectFactory.createMatch(match));
            }
            return matches;
        } catch (Exception ex) {
            return matches;
        }
    }

    public List<Cartao> readCards() {
        List<Cartao> cards = new ArrayList<>();
        try {
            List<String[]> data = Files.lines(Paths.get(cardsUrl)).map(line -> line.split(",")).collect(Collectors.toList());

            for (String[] card : data) {
                cards.add(objectFactory.createCard(card));
            }
            return cards;
        } catch (Exception ex) {
            return cards;
        }
    }

    public List<Estatistica> readStatistics() {
        List<Estatistica> statistics = new ArrayList<>();
        try {
            List<String[]> data = Files.lines(Paths.get(statisticsUrl)).map(line -> line.split(",")).collect(Collectors.toList());

            for (String[] statistic : data) {
                statistics.add(objectFactory.createStatistic(statistic));
            }
            return statistics;
        } catch (Exception ex) {
            return statistics;
        }
    }

    public List<Gol> readGoals() {
        List<Gol> goals = new ArrayList<>();

        try {
            List<String[]> data = Files.lines(Paths.get(goalsUrl)).map(line -> line.split(",")).collect(Collectors.toList());

            for (String[] goal : data) {
                goals.add(objectFactory.createGoal(goal));
            }
            return goals;
        } catch (Exception ex) {
            return goals;
        }
    }

}
