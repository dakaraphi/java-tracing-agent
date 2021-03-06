package dakaraphi.devtools.tracing.config;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Tracer {
	@JsonIgnore
	public int id = 0;

	public boolean enabled = true;
	public String name;
	public Pattern classRegex;
	public Pattern methodRegex;
	public List<Type> types = new ArrayList<>();
	public Integer line = Integer.valueOf(0);
	public List<Variable> variables = new ArrayList<>();
	public LogWhen logWhen;
	public LogStackFrames logStackFrames;

	public static class Variable {
		public String expression;
		public String name;
	}

	public static class Type {
		public Integer index;
		public Pattern typeRegex;
	}

	public static class LogWhen {
		public List<VariableCondition> variableValues = new ArrayList<>();
		public Pattern stackFramesRegex;
		public Pattern threadNameRegex;
	}

	public static class VariableCondition {
		public String name;
		public Pattern valueRegex;
	}

	public static class LogStackFrames {
		public int limit;
		public Pattern includeRegex;
		public Pattern excludeRegex;
		public boolean referenceDuplicatesByHash;
	}
}