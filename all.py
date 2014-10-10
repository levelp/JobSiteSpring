import os


def get_files(base_dir, extensions, ignored_dirs, ignored_files):
    for root, dirs, files in os.walk(base_dir):
        # Ignore specified directories
        dirs[:] = [d for d in dirs if d not in ignored_dirs]
        for file in files:
            if file in ignored_files:
                continue
            if any(file.endswith(ext) for ext in extensions):
                yield os.path.join(root, file)


# Read README.md content if it exists
def read_readme():
    readme_path = "issue.md"
    if os.path.exists(readme_path):
        with open(readme_path, 'r', encoding='utf-8') as readme_file:
            return readme_file.read()
    return ""


# Generate the Markdown file
def create_markdown(file_paths, output_file):
    readme_content = read_readme()
    with open(output_file, 'w', encoding='utf-8') as md:
        # Write README.md content at the beginning
        if readme_content:
            md.write(readme_content + "\n\n")
        for file_path in file_paths:
            with open(file_path, 'r', encoding='utf-8') as f:
                content = f.read()
            md.write(f"**{file_path}**\n\n")
            ext = os.path.splitext(file_path)[1][1:]
            md.write(f"```{ext}\n{content}\n```\n\n")


if __name__ == "__main__":
    base_dir = "."
    #extensions = [".js", ".html", ".json", ".css", ".java", ".gradle", ".groovy", '.yml']
    #extensions = [".js", ".html", ".css", ".java", ".gradle", ".groovy", '.yml']
    extensions = [".js", ".html", ".css", ".java", ".gradle", ".groovy", '.yml', 'pom.xml', 'application.properties']
    ignored_dirs = ["node_modules", ".git", ".mvn", "target"]
    ignored_files = ["all.md", "all.py", ".gitignore", "test"]

    file_paths = get_files(base_dir, extensions, ignored_dirs, ignored_files)
    create_markdown(file_paths, "all.md")
